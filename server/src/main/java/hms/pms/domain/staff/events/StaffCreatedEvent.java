package hms.pms.domain.staff.events;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class StaffCreatedEvent {
    private final UUID id;
    private final Date occurredOn;

    public StaffCreatedEvent(UUID id, Date occurredOn) {
        this.id = id;
        this.occurredOn = occurredOn;
    }
}
