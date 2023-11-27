package hms.pms.Infrastructure.jpa.entities.prescription;

import jakarta.persistence.Embeddable;

@Embeddable
public class AdministrationTimesJpaEntity {
    private String timeOfDay;
    private int unitsAdministered;
}
