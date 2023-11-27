package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.PatientCreateDTO;
import hms.pms.application.usecases.UpdatePatientFile;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.facade.PatientFacade;
import hms.pms.domain.patient.repositories.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UpdatePatientFileImpl implements UpdatePatientFile {

    private static final Logger logger = LogManager.getLogger(UpdatePatientFileImpl.class);

    private final PatientRepository patientRepository;
    private final PatientFacade patientFacade;

    @Autowired
    public UpdatePatientFileImpl(PatientRepository patientRepository, PatientFacade patientFacade) {
        this.patientRepository = patientRepository;
        this.patientFacade = patientFacade;
    }

    @Override
    public void updatePatientFile(UUID patientId, PatientCreateDTO patientFile) {
        Patient patient = patientRepository.find(patientId);

        if (patient == null) {
            logger.error("Failed to update patient file: Patient not found with ID " + patientId);
            return;
        }
        patientFacade.updatePatient(patientId, patientFile);
    }
}
