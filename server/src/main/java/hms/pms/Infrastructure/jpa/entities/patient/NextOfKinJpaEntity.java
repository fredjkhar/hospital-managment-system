package hms.pms.Infrastructure.jpa.entities.patient;

import jakarta.persistence.*;

@Embeddable
public class NextOfKinJpaEntity {
    private String firstName;
    private String lastName;
    private String relationshipToPatient;
    private String phoneNumber;

    @Embedded
    private AddressJpaEntity address;
}
