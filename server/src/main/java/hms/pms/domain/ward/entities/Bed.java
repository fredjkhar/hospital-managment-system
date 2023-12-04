package hms.pms.domain.ward.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Bed {
    private static final String STATUS_COMPLETE = "complete";
    private static final String STATUS_INCOMPLETE = "incomplete";
    private final UUID bedNbr;
    private String status;

    public Bed(UUID bedNbr) {
        this.bedNbr = bedNbr;
        this.status = STATUS_INCOMPLETE;
    }

    public void occupy() {
        this.status = STATUS_COMPLETE;
    }

    public void release() {
        this.status = STATUS_INCOMPLETE;
    }
}
