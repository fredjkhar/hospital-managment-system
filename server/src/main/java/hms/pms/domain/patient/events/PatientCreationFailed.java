package hms.pms.domain.patient.events;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;
import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public record PatientCreationFailed(UUID id, Date occurredOn, PatientInfoCreateDTO patientInfo,
                                    String reason) implements DomainEvent {
}
