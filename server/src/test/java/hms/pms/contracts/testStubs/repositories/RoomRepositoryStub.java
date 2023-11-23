package hms.pms.contracts.testStubs.repositories;

import hms.pms.domain.ward.entities.Bed;
import hms.pms.domain.ward.entities.Room;
import hms.pms.domain.ward.repositories.RoomRepository;

import java.util.HashMap;
import java.util.UUID;

public class RoomRepositoryStub implements RoomRepository {
    private HashMap<UUID, Room> rooms = new HashMap<>();

    @Override
    public Room find(UUID roomNbr) {
        return rooms.get(roomNbr);
    }

    @Override
    public void save(Room room) {
        rooms.put(room.getRoomNbr(), room);
    }
}
