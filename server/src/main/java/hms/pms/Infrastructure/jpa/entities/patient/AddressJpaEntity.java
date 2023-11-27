package hms.pms.Infrastructure.jpa.entities.patient;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressJpaEntity {
    private String street;
    private String city;
    private String country;
    private String postalCode;
}


