package hms.pms.domain.ward.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record AdmissionFailed(UUID id, Date occurredOn, UUID patientId, UUID wardId,
                              String reason) implements DomainEvent {
}

