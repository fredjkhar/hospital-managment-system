package hms.pms.domain.staff.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Staff {
    private UUID id;
    private UUID employeeNbr;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private StaffRole role;

    public Staff(UUID employeeNbr, String firstName, String lastName, String password, String email) {
        this.id = UUID.randomUUID();
        this.employeeNbr = employeeNbr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public void update(Staff updated) {
        this.firstName = updated.getFirstName();
        this.lastName = updated.getLastName();
        this.email = updated.getEmail();
    }

    public void setRole(String role) {
        this.role = new StaffRole(role);
    }
}
