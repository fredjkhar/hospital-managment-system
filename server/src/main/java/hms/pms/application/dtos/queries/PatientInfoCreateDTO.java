package hms.pms.application.dtos.queries;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class PatientInfoCreateDTO {
    private String insuranceNumber;
    private String firstName;
    private String lastName;
    private AddressCreateDTO addressInfo;
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private UUID externalDoctorId;
    private NextOfKinCreateDTO nextOfKinInfo;
    private String primaryChargeNurseId;

    public PatientInfoCreateDTO(String insuranceNumber, String firstName, String lastName,
                                AddressCreateDTO addressInfo, String phoneNumber, Date dateOfBirth,
                                String gender, String maritalStatus, UUID externalDoctorId,
                                NextOfKinCreateDTO nextOfKinInfo, String primaryChargeNurseId) {
        this.insuranceNumber = insuranceNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressInfo = addressInfo;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.externalDoctorId = externalDoctorId;
        this.nextOfKinInfo = nextOfKinInfo;
        this.primaryChargeNurseId = primaryChargeNurseId;
    }
}
