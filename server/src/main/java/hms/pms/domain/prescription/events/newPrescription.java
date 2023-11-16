package hms.pms.domain.prescription.events;

import java.util.Date;
import java.util.UUID;

public class newPrescription{
    private  UUID id;
    private  Date occurredOn;
    private  UUID prescriptionId;

    public newPrescription(UUID id, Date occurredOn, UUID prescriptionId) {
        this.id = id;
        this.occurredOn = occurredOn;
        this.prescriptionId = prescriptionId;
    }

    public UUID getId() {
        return id;
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public UUID getPrescriptionId() {
        return prescriptionId;
    }
}
