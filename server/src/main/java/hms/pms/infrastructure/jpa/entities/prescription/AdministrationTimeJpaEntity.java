package hms.pms.infrastructure.jpa.entities.prescription;

import jakarta.persistence.*;

import java.util.UUID;

@Entity()
@Table(name = "administration_time")
public class AdministrationTimeJpaEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String timeOfDay;

    @Column(nullable = false)
    private int unitsAdministered;
}
