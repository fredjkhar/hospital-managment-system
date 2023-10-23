package hms.pms.pms.Application.usecases;

import hms.pms.pms.Application.dtos.queries.PatientFileCreateDTO;

public interface UpdatePatientFile {
    Boolean updatePatientFile(PatientFileCreateDTO patientFile);
}
