package hms.pms.adapters.repositories.converters;

import hms.pms.domain.ward.entities.Bed;
import hms.pms.infrastructure.jpa.entities.ward.BedJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BedJpaConverter {
    BedJpaEntity toJpa(hms.pms.domain.ward.entities.Bed bed);

    Bed toModel(BedJpaEntity bedJpaEntity);
}
