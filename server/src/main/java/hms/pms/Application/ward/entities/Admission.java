package hms.pms.Application.ward.entities;

import java.util.UUID;

public class Admission {
    UUID id;
    UUID patientId;
    UUID localDoctorId;
    int roomNumber;
    int bedNumber;
    String insurance;

    public Admission(UUID id, UUID patientId, UUID localDoctorId, int roomNumber, int bedNumber, String insurance) {
        this.id = (id == null ? UUID.randomUUID() : id);
        this.patientId = patientId;
        this.localDoctorId = localDoctorId;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.insurance = insurance;
    }
}
