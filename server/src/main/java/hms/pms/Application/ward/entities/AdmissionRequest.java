package hms.pms.Application.ward.entities;

import java.util.UUID;

public class AdmissionRequest {
    UUID id;
    UUID patientId;
    String rationaleForRequest;
    int priorityAssessment;
    UUID localDoctorId;

    public AdmissionRequest(UUID id, UUID patientId, String rationaleForRequest, int priorityAssessment, UUID localDoctorId) {
        this.id = id;
        this.patientId = patientId;
        this.rationaleForRequest = rationaleForRequest;
        this.priorityAssessment = priorityAssessment;
        this.localDoctorId = localDoctorId;
    }
}
