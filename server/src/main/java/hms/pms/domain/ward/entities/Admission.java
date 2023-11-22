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
    private String insurance;

    public Admission(UUID patientId, UUID localDoctorId, UUID roomNbr, UUID bedNbr, String insurance) {
        this.id = UUID.randomUUID();
        this.patientId = patientId;
        this.localDoctorId = localDoctorId;
        this.roomNbr = roomNbr;
        this.bedNbr = bedNbr;
        this.insurance = insurance;
    }
}
