package hms.pms.domain.patient.entities;

public class Address {
    private String street;
    private String city;
    private String country;
    private String postalCode;

    public Address(String street, String city, String country, String postalCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

}