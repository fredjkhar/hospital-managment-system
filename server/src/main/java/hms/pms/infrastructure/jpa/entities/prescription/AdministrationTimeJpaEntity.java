package hms.pms.infrastructure.jpa.entities.prescription;

import jakarta.persistence.*;

import java.util.UUID;

@Entity()
@Table(name = "administration_time")
public class AdministrationTimeJpaEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "time_of_day", nullable = false)
    private String timeOfDay;

    @Column(name = "units_administered", nullable = false)
    private int unitsAdministered;
}
