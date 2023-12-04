package hms.pms.domain.ward.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record AdmissionFromRequestListSuccessful(UUID id, Date occurredOn, UUID wardId, UUID patientId, UUID roomNbr,
                                                 UUID bedNbr) implements DomainEvent {
}
