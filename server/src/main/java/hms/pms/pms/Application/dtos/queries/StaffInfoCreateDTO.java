package hms.pms.pms.Application.dtos.queries;

public class StaffInfoCreateDTO {
    private String employeeId;
    private StaffInfo staffInfo;

    private static class StaffInfo {
        private String firstName;
        private String lastName;
        private String jobTitle;
        private ContactInfo contactInfo;
    }

    private static class ContactInfo {
        private String email;
        private String phone;
        private String address;
    }
}
