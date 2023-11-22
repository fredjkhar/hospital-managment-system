package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PatientCreateDTO;
import hms.pms.Application.usecases.UpdatePatientFile;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.facade.PatientFacade;
import hms.pms.domain.patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UpdatePatientFileImpl implements UpdatePatientFile {

    private final PatientRepository patientRepository;
    private final PatientFacade patientFacade;

    @Autowired
    public UpdatePatientFileImpl(PatientRepository patientRepository, PatientFacade patientFacade) {
        this.patientRepository = patientRepository;
        this.patientFacade = patientFacade;
    }

    @Override
    public boolean updatePatientFile(UUID patientId, PatientCreateDTO patientFile) {
        Patient patient = patientRepository.find(patientId);

        if (patient != null) {
            return patientFacade.updatePatient(patientId, patientFile);
        }
        return false;
    }
}
