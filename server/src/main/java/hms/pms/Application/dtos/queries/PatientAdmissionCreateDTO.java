package hms.pms.Application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PatientAdmissionCreateDTO {
    private UUID patientId;
    private UUID localDoctorId;
    private UUID roomNumber;
    private UUID bedNumber;
    private String privateInsuranceNumber;
    private String rationaleForRequest;
    private int priorityAssessment;

    public PatientAdmissionCreateDTO(UUID patientId, UUID localDoctorId, UUID roomNumber,
                                     UUID bedNumber, String privateInsuranceNumber,
                                     String rationaleForRequest, int priorityAssessment) {
        this.patientId = patientId;
        this.localDoctorId = localDoctorId;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.privateInsuranceNumber = privateInsuranceNumber;
        this.rationaleForRequest = rationaleForRequest;
        this.priorityAssessment = priorityAssessment;
    }
}
