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
    private UUID patientId;

    @Column(nullable = false)
    private String insuranceNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private String maritalStatus;

    @Column
    private UUID externalDoctorId;

    @Column
    private String primaryChargeNurseId;

    @ElementCollection
    @CollectionTable(name = "prescriptions", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "prescription_id")
    private List<UUID> prescriptions;

    @Embedded
    private AddressJpaEntity address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "nok_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "nok_last_name")),
            @AttributeOverride(name = "relationshipToPatient", column = @Column(name = "nok_relationship")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "nok_phone_number")),
    })
    private NextOfKinJpaEntity nextOfKin;
}
