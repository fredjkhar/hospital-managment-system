package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.domain.ward.entities.AdmissionRequest;

public interface AdmissionRequestDTOConverter {
    AdmissionRequest convertDto(AdmissionRequestCreateDTO admissionRequest);
}
