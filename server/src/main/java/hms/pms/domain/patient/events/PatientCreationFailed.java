package hms.pms.domain.patient.events;

import hms.pms.Application.dtos.queries.PatientCreateDTO;
import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record PatientCreationFailed(UUID id, Date occurredOn, PatientCreateDTO patientInfo,
                                    String reason) implements DomainEvent {
}
