package hms.pms.adapters.repositories.converters;

import hms.pms.domain.ward.entities.Admission;
import hms.pms.infrastructure.jpa.entities.ward.AdmissionJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdmissionJpaConverter {
    AdmissionJpaEntity toJpa(Admission admission);

    Admission toModel(AdmissionJpaEntity admissionJpaEntity);
}
