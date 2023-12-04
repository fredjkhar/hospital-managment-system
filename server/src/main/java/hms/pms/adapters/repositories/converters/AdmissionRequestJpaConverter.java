package hms.pms.adapters.repositories.converters;

import hms.pms.domain.ward.entities.AdmissionRequest;
import hms.pms.infrastructure.jpa.entities.ward.AdmissionRequestJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdmissionRequestJpaConverter {
    AdmissionRequestJpaEntity toJpa(AdmissionRequest admissionRequest);

    AdmissionRequest toModel(AdmissionRequestJpaEntity admissionRequestJpaEntity);

}
