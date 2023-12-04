package hms.pms.infrastructure.jpa.entities.patient;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class NextOfKinJpaEntity {
    private String firstName;
    private String lastName;
    private String relationshipToPatient;
    private String phoneNumber;

    @Embedded
    private AddressJpaEntity address;
}
