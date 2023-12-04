package hms.pms.infrastructure.jpa.entities.staff;

import jakarta.persistence.Embeddable;

@Embeddable
public enum StaffRoleJpaEntity {
    NURSE,
    DOCTOR,
    ADMINISTRATOR,
    SUPPORT_STAFF;
}
