package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientFileCreateDTO;

public interface UpdatePatientFile {
    Boolean updatePatientFile(PatientFileCreateDTO patientFile);
}
