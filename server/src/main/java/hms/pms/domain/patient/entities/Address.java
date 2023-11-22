package hms.pms.domain.patient.entities;

import lombok.Getter;

@Getter
public final class Address {
    private final String street;
    private final String city;
    private final String country;
    private final String postalCode;

    public Address(String street, String city, String country, String postalCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }
}