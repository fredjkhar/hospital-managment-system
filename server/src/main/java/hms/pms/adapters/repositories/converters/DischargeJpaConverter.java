package hms.pms.adapters.repositories.converters;

import hms.pms.domain.ward.entities.Discharge;
import hms.pms.infrastructure.jpa.entities.ward.DischargeJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DischargeJpaConverter {
    DischargeJpaEntity toJpa(Discharge discharge);

    Discharge toModel(DischargeJpaEntity dischargeJpaEntity);
}
