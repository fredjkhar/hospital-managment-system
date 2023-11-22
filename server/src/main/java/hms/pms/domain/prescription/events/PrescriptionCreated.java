package hms.pms.domain.prescription.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record PrescriptionCreated(UUID id, Date occurredOn, UUID patientId, UUID prescriptionId) implements DomainEvent {
}

