package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.domain.ward.entities.AdmissionRequest;
import org.mapstruct.Mapper;

@Mapper
public interface AdmissionRequestDTOConverter {
    AdmissionRequest convertDto(AdmissionRequestCreateDTO admissionRequest);
}
