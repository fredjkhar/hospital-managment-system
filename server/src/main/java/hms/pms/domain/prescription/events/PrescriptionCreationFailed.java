package hms.pms.domain.prescription.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record PrescriptionCreationFailed(UUID id, Date occurredOn, UUID patientId,
                                         String reason) implements DomainEvent {
}

