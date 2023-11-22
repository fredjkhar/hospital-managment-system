package hms.pms.Application.dtos.queries;

import hms.pms.domain.staff.entities.StaffRole;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StaffInfoCreateDTO {
    public UUID employeeNbr;
    public String password;
    public String firstName;
    public String lastName;
    public String role;
    public String email;

    public StaffInfoCreateDTO(UUID employeeNbr, String password, String firstName, String lastName, String role, String email) {
        this.employeeNbr = employeeNbr;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
    }
}
