package hms.pms.application.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DischargeCreateDTO {
    private UUID patientId;
    private UUID roomNbr;
    private UUID bedNbr;
    private String dischargeSummary;
}
