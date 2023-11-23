package hms.pms.domain.ward.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AdmissionRequest {
    private UUID id;
    private UUID patientId;
    private String rationaleForRequest;
    private int priorityAssessment;
    private UUID localDoctorId;

    public AdmissionRequest(UUID id, UUID patientId, String rationaleForRequest, int priorityAssessment, UUID localDoctorId) {
        this.id = id;
        this.patientId = patientId;
        this.rationaleForRequest = rationaleForRequest;
        this.priorityAssessment = priorityAssessment;
        this.localDoctorId = localDoctorId;
    }
}
