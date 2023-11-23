package hms.pms.Application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PatientAdmissionFromRequestListCreateDTO {
    private UUID patientId;
    private String insuranceNumber;
    private String rationaleForRequest;
    private int priorityAssessment;
    private UUID localDoctor;

    public PatientAdmissionFromRequestListCreateDTO(UUID patientId, String insuranceNumber,
                                                    String rationaleForRequest, int priorityAssessment,
                                                    UUID localDoctor) {
        this.patientId = patientId;
        this.insuranceNumber = insuranceNumber;
        this.rationaleForRequest = rationaleForRequest;
        this.priorityAssessment = priorityAssessment;
        this.localDoctor = localDoctor;
    }
}
