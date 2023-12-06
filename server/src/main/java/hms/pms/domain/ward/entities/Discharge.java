package hms.pms.domain.ward.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Discharge {
    private UUID id;
    private UUID patientId;
    private String dischargeSummary;
}
