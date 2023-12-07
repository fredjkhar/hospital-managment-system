package hms.pms.application.usecases;

import hms.pms.application.dtos.responses.PatientFileViewDTO;

import java.util.UUID;

public interface ConsultPatientFile {
    PatientFileViewDTO getPatientFile(UUID patientId);
}
