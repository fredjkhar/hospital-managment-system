package hms.pms.application.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class StaffInfoCreateDTO {
    public UUID employeeNbr;
    public String password;
    public String firstName;
    public String lastName;
    public String role;
    public String email;
}
