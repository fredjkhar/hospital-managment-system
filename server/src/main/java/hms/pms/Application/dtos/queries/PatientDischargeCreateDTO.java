package hms.pms.Application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PatientDischargeCreateDTO {
    private UUID patientId;
    private UUID roomNbr;
    private UUID bedNbr;
    private String dischargeSummary;

    public PatientDischargeCreateDTO(UUID patientId, UUID roomNbr,
                                     UUID bedNbr, String dischargeSummary) {
        this.patientId = patientId;
        this.roomNbr = roomNbr;
        this.bedNbr = bedNbr;
        this.dischargeSummary = dischargeSummary;
    }
}
