package hms.pms.domain.ward.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record AdmissionFromRequestList(UUID id, Date occurredOn, UUID patientId, UUID wardId, UUID roomNbr, UUID bedNbr) implements DomainEvent {
}
