package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientCreateDTO;

import java.util.UUID;

public interface UpdatePatientFile {
    void updatePatientFile(UUID patientId, PatientCreateDTO patient);
}
