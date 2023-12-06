package hms.pms.application.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PatientFileViewDTO {
    private UUID patientId; // Added to match the JPA entity
    private String insuranceNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private char gender; // Changed from String to char
    private String maritalStatus;
    private UUID externalDoctorId;
    private String primaryChargeNurseId;
    private List<UUID> prescriptions; // Changed to match the type in JPA entity

    // Address VO
    private String street;
    private String city;
    private String postalCode;
    private String country;

    // NextOfKin VO
    private String nokFirstName; // Changed to separate fields for first and last name
    private String nokLastName;
    private String nokPhoneNumber;
    private String nokRelationship; // Changed to match the field name in JPA entity
}
