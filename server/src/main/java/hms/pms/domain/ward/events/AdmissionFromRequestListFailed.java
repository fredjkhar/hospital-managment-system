package hms.pms.domain.ward.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record AdmissionFromRequestListFailed(UUID id, Date occurredOn, UUID wardId, UUID patientId,
                                             String reason) implements DomainEvent {
}
