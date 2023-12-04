package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.domain.ward.entities.Admission;
import hms.pms.domain.ward.entities.AdmissionRequest;

public interface AdmissionDTOConverter {
    Admission convertDto(AdmissionCreateDTO patientAdmissionInfo);
}
