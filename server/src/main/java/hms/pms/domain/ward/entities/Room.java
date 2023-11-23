package hms.pms.domain.ward.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Room {
    private final String STATUS_COMPLETE = "complete";
    private final String STATUS_INCOMPLETE = "incomplete";
    private final UUID roomNbr;
    private final UUID[] beds;
    private String status;
    private int occupiedBeds;

    public Room(UUID roomNbr, UUID[] beds) {
        this.roomNbr = roomNbr;
        this.beds = beds;
        this.status = STATUS_INCOMPLETE;
        this.occupiedBeds = 0;
    }

    public boolean occupyBed() {
        if(occupiedBeds == beds.length) return false;
        ++occupiedBeds;
        return true;
    }

    public boolean releaseBed() {
        if(occupiedBeds == 0) return false;
        --occupiedBeds;
        return true;
    }


}
