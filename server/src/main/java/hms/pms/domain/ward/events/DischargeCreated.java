package hms.pms.domain.ward.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record DischargeCreated(UUID id, Date occurredOn, UUID patientId, UUID wardId, UUID roomId, UUID bedId) implements DomainEvent {
}



