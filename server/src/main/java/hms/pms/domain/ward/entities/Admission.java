package hms.pms.domain.ward.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Admission {
    private UUID id;
    private UUID patientId;
    private UUID localDoctorId;
    private UUID roomNbr;
    private UUID bedNbr;
    private String privateInsuranceNumber;
    private String rationaleForRequest;
    private int priorityAssessment;

    public Admission(UUID patientId, UUID localDoctorId, UUID roomNbr, UUID bedNbr,
                     String privateInsuranceNumber, String rationaleForRequest,
                     int priorityAssessment) {
        this.id = UUID.randomUUID();
        this.patientId = patientId;
        this.localDoctorId = localDoctorId;
        this.roomNbr = roomNbr;
        this.bedNbr = bedNbr;
        this.privateInsuranceNumber = privateInsuranceNumber;
        this.rationaleForRequest = rationaleForRequest;
        this.priorityAssessment = priorityAssessment;
    }
}
