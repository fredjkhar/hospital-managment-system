package hms.pms.infrastructure.jpa.entities.patient;

import jakarta.persistence.*;

@Embeddable
public class NextOfKinJpaEntity {
    private String firstName;
    private String lastName;
    private String relationshipToPatient;
    private String phoneNumber;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "nok_street")),
            @AttributeOverride(name = "city", column = @Column(name = "nok_city")),
            @AttributeOverride(name = "country", column = @Column(name = "nok_country")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "nok_postalCode")),
    })
    @Embedded
    private AddressJpaEntity address;
}
