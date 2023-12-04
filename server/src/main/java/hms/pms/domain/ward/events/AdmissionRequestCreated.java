package hms.pms.domain.ward.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record AdmissionRequestCreated(UUID id, Date occurredOn, UUID wardId, UUID patientId) implements DomainEvent {
}