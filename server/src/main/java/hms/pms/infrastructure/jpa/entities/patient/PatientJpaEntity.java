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
    @Column(name= "patientid",nullable = false)
    private UUID patientId;

    @Column(name = "insurancenumber",nullable = false)
    private String insuranceNumber;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "phonenumber", nullable = false)
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "dateofbirth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "gender", nullable = false)
    private char gender;

    @Column(name = "maritalstatus", nullable = false)
    private String maritalStatus;

    @Column(name = "externaldoctorid")
    private UUID externalDoctorId;

    @Column(name = "primarychargenurseid")
    private String primaryChargeNurseId;

    @Column(name = "address_street")
    private String address_street;

    @Column(name = "address_city")
    private String address_city;

    @Column(name = "address_state")
    private String address_state;

    @Column(name = "address_zipCode")
    private String address_zipCode;

    @Column(name = "nextofkin_name")
    private String nextOfKin_name;

    @Column(name = "nextofkin_phoneNumber")
    private String nextOfkin_phoneNumber;

    @Column(name = "nextofkin_relationship")
    private String nextOfKin_relationship;

}
