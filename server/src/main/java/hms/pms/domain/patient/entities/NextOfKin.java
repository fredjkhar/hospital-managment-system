package hms.pms.domain.patient.entities;

import hms.pms.Application.dtos.queries.AddressCreateDTO;
import lombok.Getter;

@Getter
public final class NextOfKin {
    private final String firstName;
    private final String lastName;
    private final String relationshipToPatient;
    private final String phoneNumber;
    private Address address;

    public NextOfKin(final String firstName, final String lastName,
                     final String relationshipToPatient, final String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationshipToPatient = relationshipToPatient;
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(AddressCreateDTO addressInfo) {
        this.address = new Address(addressInfo.getStreet(), addressInfo.getCity(),
                addressInfo.getCountry(), addressInfo.getPostalCode());
    }
}
