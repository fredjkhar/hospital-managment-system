package hms.pms.domain.ward.repositories;

import hms.pms.domain.ward.entities.Bed;
import hms.pms.domain.ward.entities.Room;

import java.util.UUID;

public interface RoomRepository {
    Room find(UUID roomNbr);
    void save(Room room);
}
