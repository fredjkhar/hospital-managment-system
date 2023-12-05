package hms.pms.application.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AdmissionCreateDTO {
    private UUID patientId;
    private UUID localDoctorId;
    private UUID roomNumber;
    private UUID bedNumber;
    private String insuranceNumber;
    private String rationaleForRequest;
    private int priorityAssessment;
}
