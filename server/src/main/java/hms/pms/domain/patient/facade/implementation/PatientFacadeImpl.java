package hms.pms.domain.patient.facade.implementation;

import hms.pms.application.dtos.queries.PatientAdmissionCreateTDO;
import hms.pms.application.dtos.queries.PatientDischargeCreateDTO;
import hms.pms.application.dtos.queries.PatientCreateDto;
import hms.pms.domain.patient.events.NewPatientCreated;
import hms.pms.domain.patient.events.PatientUpdated;
import hms.pms.domain.patient.factories.PatientFactory;
import hms.pms.domain.patient.repositories.PatientRepository;

import java.util.Date;
import java.util.UUID;

public class PatientFacadeImpl implements PatientFacade {
    private final PatientFactory patientFactory;
    private final PatientRepository patientRepository;
    private final DischargeInformationFactory dischargeInformationFactory;
    private final DomainEventEmitter eventEmitter;

    public PatientFacadeImpl(
            PatientFactory patientFactory,
            PatientRepository patientRepository,
            DischargeInformationFactory dischargeInformationFactory,
            DomainEventEmitter eventEmitter
    ) {
        this.patientFactory = patientFactory;
        this.patientRepository = patientRepository;
        this.dischargeInformationFactory = dischargeInformationFactory;
        this.eventEmitter = eventEmitter;
    }

    @Override
    public UUID createPatient(PatientCreateDto patientInfo) {
        seg3x02.PatientManagementSystem.domain.patient.entities.Patient patient = patientFactory.createPatient(patientInfo);
        patientRepository.save(patient);
        eventEmitter.emit(new NewPatientCreated(UUID.randomUUID(), new Date(), patient.getPatientId()));
        return patient.getPatientId();
    }

    @Override
    public boolean updatePatient(UUID patientId, PatientCreateDto patientInfo) {
        seg3x02.PatientManagementSystem.domain.patient.entities.Patient patient = patientRepository.find(patientId);
        if (patient != null) {
            patient.updateInfo(patientInfo);
            eventEmitter.emit(new PatientUpdated(UUID.randomUUID(), new Date(), patient.getPatientId()));
            return true;
        }
        return false;
    }

    @Override
    public boolean admitPatient(UUID patientId, UUID divisionId, UUID admissionId) {
        seg3x02.PatientManagementSystem.domain.patient.entities.Patient patient = patientRepository.find(patientId);
        if (patient != null) {
            patient.setDivisionAndAdmission(divisionId, admissionId);
            eventEmitter.emit(new PatientUpdated(UUID.randomUUID(), new Date(), patient.getPatientId()));
            return true;
        }
        return false;
    }

    @Override
    public boolean isAdmitted(UUID patientId) {
        seg3x02.PatientManagementSystem.domain.patient.entities.Patient patient = patientRepository.find(patientId);
        return patient != null && patient.isAdmitted();
    }

    @Override
    public boolean removeDivisionFromPatient(UUID patientId, DischargeInformationCreateDto dischargeInfo) {
        seg3x02.PatientManagementSystem.domain.patient.entities.Patient patient = patientRepository.find(patientId);
        if (patient != null) {
            patient.removeDivisionFromPatient(dischargeInfo, dischargeInformationFactory);
            patient.setDivisionId(null);
            patient.setAdmissionId(null);
            eventEmitter.emit(new PatientUpdated(UUID.randomUUID(), new Date(), patient.getPatientId()));
            return true;
        }
        return false;
    }

    @Override
    public UUID[] getAdmIdAndDivId(UUID patientId) {
        seg3x02.PatientManagementSystem.domain.patient.entities.Patient patient = patientRepository.find(patientId);
        if (patient != null) {
            UUID[] adIdAndDivId = patient.getAdmissionIdAndDivisionId();
            eventEmitter.emit(new PatientUpdated(UUID.randomUUID(), new Date(), patient.getPatientId()));
            return adIdAndDivId;
        }
        return null;
    }

    @Override
    public boolean addPrescription(UUID patientId, UUID prescId) {
        seg3x02.PatientManagementSystem.domain.patient.entities.Patient patient = patientRepository.find(patientId);
        if (patient != null) {
            patient.addPrescription(prescId);
            eventEmitter.emit(new PatientUpdated(UUID.randomUUID(), new Date(), patient.getPatientId()));
            return true;
        }
        return false;
    }
}
