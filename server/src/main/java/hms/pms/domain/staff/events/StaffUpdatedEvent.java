package hms.pms.domain.staff.events;

import java.util.Date;
import java.util.UUID;

public class StaffUpdatedEvent {
    private final UUID id;
    private final Date occurredOn;

    public StaffUpdatedEvent(UUID id, Date occurredOn) {
        this.id = id;
        this.occurredOn = occurredOn;
    }
}
