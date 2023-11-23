package hms.pms.domain.patient.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;


public record PatientUpdated(UUID id, Date occurredOn, UUID patientId) implements DomainEvent {
}
