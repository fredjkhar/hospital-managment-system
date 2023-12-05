package hms.pms.domain.ward.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Admission {
    private UUID id;
    private UUID patientId;
    private UUID localDoctorId;
    private UUID roomNbr;
    private UUID bedNbr;
    private String privateInsuranceNumber;
    private String rationaleForRequest;
    private int priorityAssessment;
}
