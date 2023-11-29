package hms.pms.domain.staff.entities.staff;

import hms.pms.domain.staff.entities.role.StaffRole;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Staff {
    @Getter
    private UUID id;
    private String employeeNbr;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private StaffRole role;
    private boolean availability;

    public Staff(UUID id, String firstname, String lastname, String password, String email, String employeeNbr, StaffRole role) {
        this.id = id == null ? UUID.fromString(employeeNbr) : id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.password = password;
        this.email = email;
        this.employeeNbr = employeeNbr;
        this.role = role;
        availability = true;
    }

    public void update(Staff updated) {
        firstName = updated.firstName;
        lastName = updated.lastName;
        email = updated.email;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

}



