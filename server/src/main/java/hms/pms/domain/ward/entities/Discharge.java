package hms.pms.domain.ward.entities;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Discharge {
    private final UUID patientId;
    private final String dischargeSummary;

    public Discharge(UUID patientId, String dischargeSummary) {
        this.patientId = patientId;
        this.dischargeSummary = dischargeSummary;
    }
}
