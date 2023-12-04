package hms.pms.domain.patient.facade.implementation;

import hms.pms.application.dtos.queries.AddressCreateDTO;
import hms.pms.application.dtos.queries.NextOfKinCreateDTO;
import hms.pms.application.dtos.queries.PatientInfoCreateDTO;
import hms.pms.application.services.DomainEventEmitter;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.events.PatientCreated;
import hms.pms.domain.patient.events.PatientCreationFailed;
import hms.pms.domain.patient.events.PatientUpdateFailed;
import hms.pms.domain.patient.events.PatientUpdated;
import hms.pms.domain.patient.facade.PatientFacade;
import hms.pms.domain.patient.factories.PatientFactory;
import hms.pms.domain.patient.repositories.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class PatientFacadeImpl implements PatientFacade {
    private static final Logger logger = LogManager.getLogger(PatientFacadeImpl.class);

    private final PatientRepository patientRepository;
    private final PatientFactory patientFactory;
    private final DomainEventEmitter eventEmitter;

    @Autowired
    public PatientFacadeImpl(PatientRepository patientRepository,
                             PatientFactory patientFactory,
                             DomainEventEmitter eventEmitter) {
        this.patientRepository = patientRepository;
        this.patientFactory = patientFactory;
        this.eventEmitter = eventEmitter;
    }

    @Override
    public void createPatient(PatientInfoCreateDTO patientInfo) {
        if (patientRepository.find(patientInfo.getInsuranceNumber()) != null) {
            String msg = "Creation failed: Patient with insurance number " + patientInfo.getInsuranceNumber() + " already exists.";
            logger.warn(msg);
            eventEmitter.emit(new PatientCreationFailed(UUID.randomUUID(), new Date(), patientInfo, msg));
            return;
        }

        Patient patient = patientFactory.createPatient(patientInfo);
        setPatientDetails(patient, patientInfo);

        try {
            patientRepository.save(patient);
            logger.info("Patient created successfully: " + patient.getPatientId());
            eventEmitter.emit(new PatientCreated(UUID.randomUUID(), new Date(), patient.getPatientId()));
        } catch (Exception e) {
            logger.error("Error creating patient: ", e);
            eventEmitter.emit(new PatientCreationFailed(UUID.randomUUID(), new Date(), patientInfo, e.getMessage()));
        }
    }

    @Override
    public void updatePatient(UUID patientID, PatientInfoCreateDTO patientInfo) {
        Patient patient = patientRepository.find(patientID);
        if (patient == null) {
            String msg = "Update failed: Patient not found with ID " + patientID;
            logger.warn(msg);
            eventEmitter.emit(new PatientUpdateFailed(UUID.randomUUID(), new Date(), patientID, msg));
            return;
        }

        Patient updatedPatient = patientFactory.createPatient(patientInfo);
        patient.update(updatedPatient);
        setPatientDetails(patient, patientInfo);

        try {
            patientRepository.save(patient);
            logger.info("Patient updated successfully: " + patient.getPatientId());
            eventEmitter.emit(new PatientUpdated(UUID.randomUUID(), new Date(), patient.getPatientId()));
        } catch (Exception e) {
            logger.error("Error updating patient: ", e);
            eventEmitter.emit(new PatientUpdateFailed(UUID.randomUUID(), new Date(), patientID, e.getMessage()));
        }
    }

    private void setPatientDetails(Patient patient, PatientInfoCreateDTO patientInfo) {
        AddressCreateDTO addressInfo = patientInfo.getAddressInfo();
        patient.setAddress(addressInfo);

        NextOfKinCreateDTO nextOfKinInfo = patientInfo.getNextOfKinInfo();
        patient.setNextOfKin(nextOfKinInfo);
    }
}
