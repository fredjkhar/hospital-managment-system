package hms.pms.infrastructure.jpa.entities.staff;

import hms.pms.domain.staff.entities.StaffRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "staff")
public class StaffJpaEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "employee_nbr", nullable = false, unique = true)
    private UUID employeeNbr;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "role")
    private String role;
}

