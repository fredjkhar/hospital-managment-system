package hms.pms.application.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AdmissionRequestCreateDTO {
    private UUID id;
    private UUID patientId;
    private String insuranceNumber;
    private String rationaleForRequest;
    private int priorityAssessment;
    private UUID localDoctor;
}
