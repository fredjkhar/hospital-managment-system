package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.RoomJpaConverter;
import hms.pms.domain.ward.entities.Room;
import hms.pms.domain.ward.repositories.RoomRepository;
import hms.pms.infrastructure.jpa.dao.RoomJpaRepository;
import hms.pms.infrastructure.jpa.entities.ward.RoomJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"rooms"})
public class RoomJpaAdapter implements RoomRepository {
    private final RoomJpaRepository roomJpaRepository;
    private final RoomJpaConverter converter = Mappers.getMapper(RoomJpaConverter.class);

    @Autowired
    public RoomJpaAdapter(RoomJpaRepository roomJpaRepository) {
        this.roomJpaRepository = roomJpaRepository;
    }

    @Cacheable(key = "#roomNbr")
    @Transactional
    @Override
    public Room find(UUID roomNbr) {
        return roomJpaRepository.findById(roomNbr)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#room.getId()")
    @Override
    public void save(Room room) {
        RoomJpaEntity roomJpa = converter.toJpa(room);
        roomJpaRepository.save(roomJpa);
    }
}
