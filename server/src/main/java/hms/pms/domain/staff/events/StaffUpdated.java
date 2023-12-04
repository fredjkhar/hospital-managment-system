package hms.pms.domain.staff.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record StaffUpdated(UUID id, Date occurredOn) implements DomainEvent {
}
