package hms.pms.domain.staff.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record StaffUpdateFailed(UUID id, Date occurredOn, String reason) implements DomainEvent {
}
