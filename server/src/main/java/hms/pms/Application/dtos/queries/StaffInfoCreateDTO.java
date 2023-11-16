package hms.pms.Application.dtos.queries;

import hms.pms.domain.staff.entities.role.StaffRole;

public class StaffInfoCreateDTO {
    public String employeeNbr;
    public String password;
    public String firstName;
    public String lastName;
    public StaffRole role;
    public String email;
}
