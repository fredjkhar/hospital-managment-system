package hms.pms.Infrastructure.jpa.dao;

import hms.pms.domain.ward.entities.Room;
import hms.pms.domain.ward.repositories.RoomRepository;

import java.util.UUID;

public class RoomJpaRepository implements RoomRepository {
    @Override
    public Room find(UUID roomNbr) {
        return null;
    }

    @Override
    public void save(Room room) {

    }
}
