package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientCreateDTO;

import java.util.UUID;

public interface UpdatePatientFile {
    boolean updatePatientFile(UUID patientId, PatientCreateDTO patient);
}
