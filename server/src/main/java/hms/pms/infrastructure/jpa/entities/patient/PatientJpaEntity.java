package hms.pms.infrastructure.jpa.entities.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class PatientJpaEntity {
    @Id
    @GeneratedValue
    @Column(name= "patient_id",nullable = false)
    private UUID patientId;

    @Column(name = "insurance_number",nullable = false)
    private String insuranceNumber;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "gender", nullable = false)
    private char gender;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @Column(name = "external_doctor_id")
    private UUID externalDoctorId;

    @Column(name = "primary_charge_nurse_id")
    private String primaryChargeNurseId;
}
