package hms.pms.domain.ward.facade.implementation;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.application.dtos.queries.DischargeCreateDTO;
import hms.pms.application.services.DomainEventEmitter;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.*;
import hms.pms.domain.ward.events.*;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.factories.AdmissionFactory;
import hms.pms.domain.ward.factories.AdmissionRequestFactory;
import hms.pms.domain.ward.factories.DischargeFactory;
import hms.pms.domain.ward.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class WardFacadeImpl implements WardFacade {
    private static final Logger logger = LogManager.getLogger(WardFacadeImpl.class);

    private final WardRepository wardRepository;
    private final RoomRepository roomRepository;
    private final BedRepository bedRepository;
    private final PatientRepository patientRepository;
    private final AdmissionRepository admissionRepository;
    private final AdmissionRequestRepository admissionRequestRepository;
    private final AdmissionFactory admissionFactory;
    private final AdmissionRequestFactory admissionRequestFactory;
    private final DischargeFactory dischargeFactory;
    private final DomainEventEmitter eventEmitter;

    @Autowired
    public WardFacadeImpl(WardRepository wardRepository, RoomRepository roomRepository,
                          BedRepository bedRepository, PatientRepository patientRepository,
                          AdmissionRepository admissionRepository, AdmissionRequestRepository admissionRequestRepository,
                          AdmissionFactory admissionFactory, AdmissionRequestFactory admissionRequestFactory,
                          DischargeFactory dischargeFactory, DomainEventEmitter eventEmitter) {
        this.wardRepository = wardRepository;
        this.roomRepository = roomRepository;
        this.bedRepository = bedRepository;
        this.patientRepository = patientRepository;
        this.admissionRepository = admissionRepository;
        this.admissionRequestRepository = admissionRequestRepository;
        this.admissionFactory = admissionFactory;
        this.admissionRequestFactory = admissionRequestFactory;
        this.dischargeFactory = dischargeFactory;
        this.eventEmitter = eventEmitter;
    }

    @Override
    public Ward getWard(UUID wardId) {
        return wardRepository.find(wardId);
    }

    @Override
    public void admitPatient(UUID wardId, AdmissionCreateDTO admissionInfo) {
        Ward ward = getWard(wardId);
        if (ward == null || Objects.equals(ward.getStatus(), "complete")) {
            logAndEmitAdmissionFailed("Ward is null or complete", wardId, admissionInfo);
            return;
        }

        UUID patientId = admissionInfo.getPatientId();
        if (patientId == null || patientRepository.find(patientId) == null) {
            logAndEmitAdmissionFailed("Patient not found", wardId, admissionInfo);
            return;
        }

        UUID admissionId = admissionInfo.getId();
        Admission admission = admissionRepository.find(admissionId);
        if (admissionId != null && admission != null) {
            logAndEmitAdmissionFailed("Admission already exists for patient", wardId, admissionInfo);
            return;
        }

        admission = admissionFactory.createAdmission(admissionInfo);
        if (!validateRoomAndBedForAdmission(ward, admission)) {
            logAndEmitAdmissionFailed("Invalid room or bed for admission", wardId, admissionInfo);
            return;
        }

        if (!ward.admitPatient(admissionId)) {
            logAndEmitAdmissionFailed("Failed to admit patient in the ward system", wardId, admissionInfo);
            return;
        }

        Room room = roomRepository.find(admission.getRoomNbr());
        Bed bed = bedRepository.find(admission.getBedNbr());
        room.occupyBed();
        bed.occupy();
        roomRepository.save(room);
        bedRepository.save(bed);

        wardRepository.save(ward);
        eventEmitter.emit(new AdmissionSuccessful(UUID.randomUUID(), new Date(), patientId, wardId, admission.getRoomNbr(), admission.getBedNbr()));
    }

    @Override
    public void admitPatientFromRequestList(UUID wardId, AdmissionRequestCreateDTO patientAdmissionRequestInfo) {
        Ward ward = getWard(wardId);
        if (ward == null || Objects.equals(ward.getStatus(), "complete")) {
            logAndEmitAdmissionRequestListFailed("Ward is null or complete", wardId, patientAdmissionRequestInfo);
            return;
        }

        UUID patientId = patientAdmissionRequestInfo.getPatientId();
        if (patientId == null || patientRepository.find(patientId) == null) {
            logAndEmitAdmissionRequestListFailed("Patient not found", wardId, patientAdmissionRequestInfo);
            return;
        }

        UUID admissionRequestId = patientAdmissionRequestInfo.getId();
        AdmissionRequest admissionRequest = admissionRequestRepository.find(admissionRequestId);
        if (admissionRequest == null) {
            logAndEmitAdmissionRequestListFailed("Admission request not found", wardId, patientAdmissionRequestInfo);
            return;
        }

        Room incompleteRoom = null;
        Bed incompleteBed = null;

        for (UUID roomNbr : ward.getRooms()) {
            Room room = roomRepository.find(roomNbr);
            if (room != null && Objects.equals(room.getStatus(), "incomplete")) {
                incompleteBed = findIncompleteBed(room);
                if (incompleteBed != null) {
                    incompleteRoom = room;
                    break;
                }
            }
        }

        if (incompleteRoom == null || incompleteBed == null) {
            logAndEmitAdmissionRequestListFailed("Target room or bed not found", wardId, patientAdmissionRequestInfo);
            return;
        }

        if (!ward.removePatientFromRequestList(admissionRequestId)) {
            logAndEmitAdmissionRequestListFailed("Failed to remove patient from request list in the ward system", wardId, patientAdmissionRequestInfo);
            return;
        }

        Admission admission = admissionFactory.createAdmission(admissionRequest, incompleteRoom.getRoomNbr(), incompleteBed.getBedNbr(), patientAdmissionRequestInfo.getInsuranceNumber());
        if (!ward.admitPatient(admission.getId())) {
            logAndEmitAdmissionFailed("Failed to admit patient in the ward system", wardId, admission);
            return;
        }

        incompleteRoom.occupyBed();
        incompleteBed.occupy();
        roomRepository.save(incompleteRoom);
        bedRepository.save(incompleteBed);

        wardRepository.save(ward);
        eventEmitter.emit(new AdmissionFromRequestListSuccessful(UUID.randomUUID(), new Date(), patientId, wardId, incompleteRoom.getRoomNbr(), incompleteBed.getBedNbr()));
    }

    @Override
    public void addPatientToRequestList(UUID wardId, AdmissionRequestCreateDTO patientAdmissionInfo) {
        Ward ward = getWard(wardId);
        if (ward == null) {
            logger.error("Ward not found for ID " + wardId);
            eventEmitter.emit(new AdmissionFromRequestListFailed(UUID.randomUUID(), new Date(), wardId, patientAdmissionInfo.getPatientId(), "Ward not found"));
            return;
        }

        UUID patientId = patientAdmissionInfo.getPatientId();
        if (ward.getAdmissionRequest(patientId) != null || ward.getAdmission(patientId) != null) {
            logger.error("Patient already in request list or admitted.");
            eventEmitter.emit(new AdmissionRequestFailed(UUID.randomUUID(), new Date(), wardId, patientId, "Patient already in request list or admitted"));
            return;
        }

        AdmissionRequest admissionRequest = admissionRequestFactory.createAdmissionRequest(patientAdmissionInfo);

        ward.getAdmissionRequests().add(admissionRequest.getId());
        logger.info("Patient added to admission request list for ward " + wardId);

        wardRepository.save(ward);
        eventEmitter.emit(new AdmissionRequestCreated(UUID.randomUUID(), new Date(), wardId, patientId));
    }

    @Override
    public void dischargePatient(UUID wardId, DischargeCreateDTO patientDischargeInfo) {
        Ward ward = getWard(wardId);
        if (ward == null) {
            logAndEmitDischargeFailed("Ward not found", wardId, patientDischargeInfo);
            return;
        }

        UUID patientId = patientDischargeInfo.getPatientId();
        if (patientId == null || patientRepository.find(patientId) == null) {
            logAndEmitDischargeFailed("Patient not found", wardId, patientDischargeInfo);
            return;
        }

        Admission admission = admissionRepository.findByPatientId(patientId);
        if (admission == null) {
            logAndEmitDischargeFailed("Admission not found", wardId, patientDischargeInfo);
            return;
        }

        Discharge discharge = dischargeFactory.createDischarge(patientDischargeInfo);
        if (!validateRoomAndBedForDischarge(ward, admission, patientDischargeInfo)) {
            logAndEmitDischargeFailed("Invalid room or bed for discharge", wardId, patientDischargeInfo);
            return;
        }

        processRoomAndBedRelease(admission);

        if (!ward.dischargePatient(discharge.getId(), admission.getId())) {
            logAndEmitDischargeFailed("Failed to discharge patient in the ward system", wardId, patientDischargeInfo);
            return;
        }

        wardRepository.save(ward);
        eventEmitter.emit(new DischargeCreated(UUID.randomUUID(), new Date(), patientId, wardId, admission.getRoomNbr(), admission.getBedNbr()));
    }

    private void logAndEmitAdmissionFailed(String message, UUID wardId, AdmissionCreateDTO admissionInfo) {
        logger.error("Patient admission failed: " + message);
        eventEmitter.emit(new AdmissionFailed(UUID.randomUUID(), new Date(), wardId, admissionInfo.getPatientId(), message));
    }

    private void logAndEmitAdmissionFailed(String message, UUID wardId, Admission admission) {
        logger.error("Patient admission failed: " + message);
        eventEmitter.emit(new AdmissionFailed(UUID.randomUUID(), new Date(), wardId, admission.getPatientId(), message));
    }

    private boolean validateRoomAndBedForAdmission(Ward ward, Admission admission) {
        UUID roomNbr = admission.getRoomNbr();
        Room room = roomRepository.find(roomNbr);
        if (room == null || Objects.equals(room.getStatus(), "complete")) return false;
        if (!isRoomPartOfWard(ward.getRooms(), roomNbr)) return false;

        UUID bedNbr = admission.getBedNbr();
        Bed bed = bedRepository.find(bedNbr);
        return !(bed == null || Objects.equals(bed.getStatus(), "complete")) && isBedPartOfRoom(room.getBeds(), bedNbr);
    }

    private void logAndEmitAdmissionRequestListFailed(String message, UUID wardId, AdmissionRequestCreateDTO patientAdmissionRequestInfo) {
        logger.error("Admission from request list failed: " + message);
        eventEmitter.emit(new AdmissionFromRequestListFailed(UUID.randomUUID(), new Date(), wardId, patientAdmissionRequestInfo.getPatientId(), message));
    }

    private Bed findIncompleteBed(Room room) {
        for (UUID bedNbr : room.getBeds()) {
            Bed bed = bedRepository.find(bedNbr);
            if (bed != null && Objects.equals(bed.getStatus(), "incomplete")) {
                return bed;
            }
        }
        return null;
    }

    private void logAndEmitDischargeFailed(String message, UUID wardId, DischargeCreateDTO patientDischargeInfo) {
        logger.error("Patient discharge failed: " + message);
        eventEmitter.emit(new DischargeFailed(UUID.randomUUID(), new Date(), wardId, patientDischargeInfo.getPatientId(), message));
    }

    private boolean validateRoomAndBedForDischarge(Ward ward, Admission admission, DischargeCreateDTO patientDischargeInfo) {
        UUID roomNbr = admission.getRoomNbr();
        Room room = roomRepository.find(roomNbr);
        if (room == null || Objects.equals(room.getStatus(), "complete")) return false;
        if (!isRoomPartOfWard(ward.getRooms(), roomNbr)) return false;

        UUID bedNbr = admission.getBedNbr();
        Bed bed = bedRepository.find(bedNbr);
        if (bed == null || Objects.equals(bed.getStatus(), "incomplete")) return false;
        if (!isBedPartOfRoom(room.getBeds(), bedNbr)) return false;

        return patientDischargeInfo.getRoomNbr().equals(roomNbr) && patientDischargeInfo.getBedNbr().equals(bedNbr);
    }

    private void processRoomAndBedRelease(Admission admission) {
        UUID roomNbr = admission.getRoomNbr();
        Room room = roomRepository.find(roomNbr);
        UUID bedNbr = admission.getBedNbr();
        Bed bed = bedRepository.find(bedNbr);

        if (room != null && bed != null) {
            room.releaseBed();
            bed.release();
            roomRepository.save(room);
            bedRepository.save(bed);
        }
    }

    private boolean isRoomPartOfWard(UUID[] rooms, UUID roomNbr) {
        for (UUID id : rooms) {
            if (Objects.equals(roomNbr, id)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBedPartOfRoom(UUID[] beds, UUID bedNbr) {
        for (UUID id : beds) {
            if (Objects.equals(bedNbr, id)) {
                return true;
            }
        }
        return false;
    }
}