package hms.pms.domain.ward.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Room {
    private static final String STATUS_COMPLETE = "complete";
    private static final String STATUS_INCOMPLETE = "incomplete";
    private UUID roomNbr;
    private UUID[] beds;
    private String status;
    private int occupiedBeds;

    public Room(UUID roomNbr, UUID[] beds) {
        this.roomNbr = roomNbr;
        this.beds = beds;
        this.status = STATUS_INCOMPLETE;
        this.occupiedBeds = 0;
    }

    public boolean occupyBed() {
        if (occupiedBeds == beds.length) {
            return false;
        }
        ++occupiedBeds;
        updateRoomStatus();
        return true;
    }

    public boolean releaseBed() {
        if (occupiedBeds == 0) {
            return false;
        }
        --occupiedBeds;
        updateRoomStatus();
        return true;
    }

    private void updateRoomStatus() {
        if (occupiedBeds == beds.length) {
            status = STATUS_COMPLETE;
        } else {
            status = STATUS_INCOMPLETE;
        }
    }
}
