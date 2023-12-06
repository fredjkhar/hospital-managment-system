package hms.pms.domain.prescription.facade.implementation;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.application.services.DomainEventEmitter;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;

import hms.pms.domain.prescription.Entities.Prescription;
import hms.pms.domain.prescription.events.PrescriptionCreated;
import hms.pms.domain.prescription.events.PrescriptionCreationFailed;
import hms.pms.domain.prescription.events.PrescriptionUpdateFailed;
import hms.pms.domain.prescription.events.PrescriptionUpdated;
import hms.pms.domain.prescription.facade.PrescriptionFacade;

import hms.pms.domain.prescription.factory.PrescriptionFactory;

import hms.pms.domain.prescription.repository.PrescriptionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class PrescriptionFacadeImpl implements PrescriptionFacade {
    private static final Logger logger = LogManager.getLogger(PrescriptionFacadeImpl.class);

    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;
    private final PrescriptionFactory prescriptionFactory;
    private final DomainEventEmitter eventEmitter;

    @Autowired
    public PrescriptionFacadeImpl(PrescriptionRepository prescriptionRepository,
                                  PatientRepository patientRepository,
                                  PrescriptionFactory prescriptionFactory,
                                  DomainEventEmitter eventEmitter) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
        this.prescriptionFactory = prescriptionFactory;
        this.eventEmitter = eventEmitter;
    }

    @Override
    public void createPrescription(UUID patientId, PrescriptionCreateDTO prescriptionInfo) {
        Patient patient = patientRepository.find(patientId);
        if (patient == null) {
            logger.warn("Failed to create prescription: Patient not found, ID: " + patientId);
            eventEmitter.emit(new PrescriptionCreationFailed(UUID.randomUUID(), new Date(), patientId, "Patient not found"));
            return;
        }

        Prescription prescription = prescriptionFactory.createPrescription(prescriptionInfo);

        patient.addPrescription(prescription.getPrescriptionId());
        prescriptionRepository.save(prescription);

        logger.info("Prescription created successfully: " + prescription.getPrescriptionId());
        eventEmitter.emit(new PrescriptionCreated(UUID.randomUUID(), new Date(), patient.getPatientId(), prescription.getPrescriptionId()));
    }

    @Override
    public void updatePrescription(UUID prescriptionId, UUID patientId, PrescriptionCreateDTO prescriptionInfo) {
        Patient patient = patientRepository.find(patientId);
        Prescription prescription = prescriptionRepository.find(prescriptionId);
        if (patient == null || prescription == null) {
            logger.warn("Failed to update prescription: Patient or Prescription not found");
            eventEmitter.emit(new PrescriptionUpdateFailed(UUID.randomUUID(), new Date(), patientId, prescriptionId, "Patient or Prescription not found"));
            return;
        }

        Prescription updated = prescriptionFactory.createPrescription(prescriptionInfo);

        prescription.update(updated);
        prescriptionRepository.save(prescription);

        logger.info("Prescription updated successfully: " + prescription.getPrescriptionId());
        eventEmitter.emit(new PrescriptionUpdated(UUID.randomUUID(), new Date(), patient.getPatientId(), prescription.getPrescriptionId()));
    }
}
