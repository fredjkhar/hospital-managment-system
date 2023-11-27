package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.application.usecases.PrescribeMedication;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.prescription.facade.PrescriptionFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class PrescribeMedicationImpl implements PrescribeMedication {

    private static final Logger logger = LogManager.getLogger(PrescribeMedicationImpl.class);

    private final PatientRepository patientRepository;
    private final PrescriptionFacade prescriptionFacade;

    @Autowired
    public PrescribeMedicationImpl(PatientRepository patientRepository, PrescriptionFacade prescriptionFacade) {
        this.patientRepository = patientRepository;
        this.prescriptionFacade = prescriptionFacade;
    }

    @Override
    public void prescribeMedication(UUID patientId, PrescriptionCreateDTO prescription) {
        Patient patient = patientRepository.find(patientId);

        if (patient == null) {
            logger.error("Failed to prescribe medication: Patient not found with ID " + patientId);
            return; // Optionally, consider throwing a custom exception
        }

        prescriptionFacade.createPrescription(patientId, prescription);
        logger.info("Medication prescribed for patient ID " + patientId);
    }
}
