package hms.pms.domain.staff.events;

import hms.pms.domain.common.DomainEvent;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

public record StaffCreated(UUID id, Date occurredOn) implements DomainEvent {
}
