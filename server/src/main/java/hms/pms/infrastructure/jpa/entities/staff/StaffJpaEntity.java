package hms.pms.infrastructure.jpa.entities.staff;

import hms.pms.domain.staff.entities.StaffRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "staff")
public class StaffJpaEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID employeeNbr;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING) // or @Column, depending on how StaffRole is defined
    private StaffRole role;
}
