package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;

import java.util.UUID;

public interface UpdatePatientFile {
    void updatePatientFile(UUID patientId, PatientInfoCreateDTO patient);
}
