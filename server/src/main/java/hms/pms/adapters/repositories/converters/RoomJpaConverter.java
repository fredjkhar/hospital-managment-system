package hms.pms.adapters.repositories.converters;

import hms.pms.domain.ward.entities.Room;
import hms.pms.infrastructure.jpa.entities.ward.RoomJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomJpaConverter {
    RoomJpaEntity toJpa(Room room);

    Room toModel(RoomJpaEntity roomJpaEntity);
}
