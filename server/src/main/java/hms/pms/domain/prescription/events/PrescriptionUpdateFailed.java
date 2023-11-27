package hms.pms.domain.prescription.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record PrescriptionUpdateFailed(UUID id, Date occurredOn, UUID patientId, UUID prescriptionId,
                                       String reason) implements DomainEvent {
}

