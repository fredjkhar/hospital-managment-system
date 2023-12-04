package hms.pms.adapters.repositories.converters;

import hms.pms.domain.ward.entities.Ward;
import hms.pms.infrastructure.jpa.entities.ward.WardJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WardJpaConverter {
    WardJpaEntity toJpa(Ward ward);

    Ward toModel(WardJpaEntity wardJpaEntity);
}
