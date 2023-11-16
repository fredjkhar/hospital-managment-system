package hms.pms.domain.patient.events;

import hms.pms.domain.common.DomainEvent;

import java.util.Date;
import java.util.UUID;

public class NewPatientCreated implements DomainEvent {
    private final UUID id;
    private final Date occurredOn;
    private final UUID patientId;

    public NewPatientCreated(UUID id, Date occurredOn, UUID patientId) {
        this.id = id;
        this.occurredOn = occurredOn;
        this.patientId = patientId;
    }

    public UUID getId() {
        return id;
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public UUID getPatientId() {
        return patientId;
    }
}
