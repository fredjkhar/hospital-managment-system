package hms.pms.Application.dtos.queries;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class PatientCreateDTO {
    private String insuranceNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String telephoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String externalDoctorId;
    private NextOfKin nextOfKin;
    private String primaryChargeNurseId;

    public static class NextOfKin {
        private String fullName;
        private String relationship;
        private String address;
        private String telephoneNumber;
    }
}
