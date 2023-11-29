package hms.pms.Application.dtos.queries;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class PatientCreateDTO {
    private String insuranceNumber;
    private String firstName;
    private String lastName;
    private Address address;
    private String telephoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String externalDoctorId;
    private NextOfKin nextOfKin;
    private String primaryChargeNurseId;

    private static class Address {
        private String street;
        private String city;
        private String country;
        private String postalcode;
    }
    
    private static class NextOfKin {
        private String fullName;
        private String relationship;
        private String address;
        private String telephoneNumber;
    }

}
