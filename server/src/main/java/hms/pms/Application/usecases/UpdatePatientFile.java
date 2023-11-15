package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientCreateDTO;

import java.util.UUID;

public interface UpdatePatientFile {
    Boolean updatePatientFile(PatientCreateDTO patient, UUID patientId);
}
