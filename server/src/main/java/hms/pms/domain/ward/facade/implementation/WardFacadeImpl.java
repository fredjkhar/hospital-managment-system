package hms.pms.domain.ward.facade.implementation;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateDTO;
import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;
import hms.pms.Application.dtos.queries.PatientDischargeCreateDTO;
import hms.pms.Application.services.DomainEventEmitter;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.*;
import hms.pms.domain.ward.events.AdmissionCreated;
import hms.pms.domain.ward.events.AdmissionFromRequestList;
import hms.pms.domain.ward.events.DischargeCreated;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.factories.AdmissionFactory;
import hms.pms.domain.ward.factories.AdmissionRequestFactory;
import hms.pms.domain.ward.factories.DischargeFactory;
import hms.pms.domain.ward.repositories.BedRepository;
import hms.pms.domain.ward.repositories.RoomRepository;
import hms.pms.domain.ward.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class WardFacadeImpl implements WardFacade {
    private final WardRepository wardRepository;
    private final RoomRepository roomRepository;
    private final BedRepository bedRepository;
    private final PatientRepository patientRepository;
    private final AdmissionFactory admissionFactory;
    private final AdmissionRequestFactory admissionRequestFactory;
    private final DischargeFactory dischargeFactory;
    private final DomainEventEmitter eventEmitter;

    @Autowired
    public WardFacadeImpl(WardRepository wardRepository, RoomRepository roomRepository,
                          BedRepository bedRepository, PatientRepository patientRepository,
                          AdmissionFactory admissionFactory, AdmissionRequestFactory admissionRequestFactory,
                          DischargeFactory dischargeFactory, DomainEventEmitter eventEmitter) {
        this.wardRepository = wardRepository;
        this.roomRepository = roomRepository;
        this.bedRepository = bedRepository;
        this.patientRepository = patientRepository;
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
    public boolean admitPatient(UUID wardId, PatientAdmissionCreateDTO admissionInfo) {
        Ward ward = getWard(wardId);
        if (ward == null || Objects.equals(ward.getStatus(), "complete")) return false;

        UUID patientId = admissionInfo.getPatientId();
        if (patientId == null || patientRepository.find(patientId) == null) return false;

        Admission admission = ward.getAdmission(patientId);
        if (admission != null) return false;

        admission = admissionFactory.createAdmission(admissionInfo);

        UUID roomNbr = admission.getRoomNbr();
        Room room = roomRepository.find(roomNbr);
        if (room == null || Objects.equals(room.getStatus(), "complete")) return false;
        if (!isRoomPartOfWard(ward.getRooms(), roomNbr)) return false;


        UUID bedNbr = admission.getBedNbr();
        Bed bed = bedRepository.find(bedNbr);
        if (bed == null || Objects.equals(bed.getStatus(), "complete")) return false;
        if (!isBedIsPartOfRoom(room.getBeds(), bedNbr)) return false;

        if(!ward.admitPatient(admission)) return false;

        room.occupyBed();
        bed.occupy();
        roomRepository.save(room);
        bedRepository.save(bed);

        wardRepository.save(ward);
        eventEmitter.emit(new AdmissionCreated(UUID.randomUUID(), new Date(), patientId, wardId, roomNbr, bedNbr));
        return true;
    }

    @Override
    public boolean admitPatientFromRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientAdmissionRequestInfo) {
        Ward ward = getWard(wardId);
        if (ward == null || Objects.equals(ward.getStatus(), "complete")) return false;

        UUID patientId = patientAdmissionRequestInfo.getPatientId();
        if (patientId == null || patientRepository.find(patientId) == null) return false;

        AdmissionRequest admissionRequest = ward.getAdmissionRequest(patientId);
        if (admissionRequest == null) return false;

        UUID[] rooms = ward.getRooms();
        Room incompleteRoom = null;
        for (UUID roomNbr : rooms) {
            Room room = roomRepository.find(roomNbr);
            if (Objects.equals(room.getStatus(), "incomplete")) incompleteRoom = room;
        }
        if (incompleteRoom == null) return false;

        Bed incompleteBed = null;
        UUID[] beds = incompleteRoom.getBeds();
        for (UUID bedNbr : beds) {
            Bed bed = bedRepository.find(bedNbr);
            if (Objects.equals(bed.getStatus(), "incomplete")) incompleteBed = bed;
        }
        if (incompleteBed == null) return false;

        if (!ward.admitPatientFromRequestList(admissionRequest)) return false;

        incompleteRoom.occupyBed();
        incompleteBed.occupy();
        roomRepository.save(incompleteRoom);
        bedRepository.save(incompleteBed);

        wardRepository.save(ward);
        eventEmitter.emit(new AdmissionFromRequestList(UUID.randomUUID(), new Date(), patientId, wardId, incompleteRoom.getRoomNbr(), incompleteBed.getBedNbr()));
        return true;
    }


    @Override
    public boolean dischargePatient(UUID wardId, PatientDischargeCreateDTO patientDischargeInfo) {
        Ward ward = getWard(wardId);
        if (ward == null) return false;

        UUID patientId = patientDischargeInfo.getPatientId();
        if (patientId == null || patientRepository.find(patientId) == null) return false;

        Admission admission = ward.getAdmission(patientId);
        if (admission == null) return false;

        Discharge discharge = dischargeFactory.createDischarge(patientDischargeInfo.getPatientId(),
                patientDischargeInfo.getDischargeSummary());

        UUID roomNbr = admission.getRoomNbr();
        Room room = roomRepository.find(roomNbr);
        if (room == null || Objects.equals(room.getStatus(), "complete")) return false;
        if (!isRoomPartOfWard(ward.getRooms(), roomNbr)) return false;


        UUID bedNbr = admission.getBedNbr();
        Bed bed = bedRepository.find(bedNbr);
        if (bed == null || Objects.equals(bed.getStatus(), "incomplete")) return false;
        if (!isBedIsPartOfRoom(room.getBeds(), bedNbr)) return false;


        if (patientDischargeInfo.getRoomNbr() != roomNbr ||
                patientDischargeInfo.getBedNbr() != bedNbr) return false;

        room.releaseBed();
        bed.release();
        roomRepository.save(room);
        bedRepository.save(bed);

        if (!ward.dischargePatient(discharge, admission)) return false;
        wardRepository.save(ward);

        eventEmitter.emit(new DischargeCreated(UUID.randomUUID(), new Date(), patientId, wardId, roomNbr, bedNbr));
        return true;
    }

    boolean isRoomPartOfWard(UUID[] rooms, UUID roomNbr) {
        for (UUID id : rooms) {
            if (roomNbr == id) return true;
        }
        return false;
    }

    boolean isBedIsPartOfRoom(UUID[] beds, UUID bedNbr) {
        for (UUID id : beds) {
            if (bedNbr == id) return true;
        }
        return false;
    }
}
