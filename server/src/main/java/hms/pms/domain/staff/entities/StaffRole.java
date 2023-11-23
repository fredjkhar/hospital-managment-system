package hms.pms.domain.staff.entities;

import lombok.Getter;

@Getter
public final class StaffRole {
    private final String role;

    public StaffRole(String role) {
        this.role = role;
    }
}
