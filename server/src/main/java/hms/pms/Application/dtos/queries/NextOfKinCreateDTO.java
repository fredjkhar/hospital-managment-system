package hms.pms.Application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NextOfKinCreateDTO {
    private String firstName;
    private String lastName;
    private String relationship;
    private AddressCreateDTO address;
    private String phoneNumber;

    public NextOfKinCreateDTO(String firstName, String lastName, String relationship,
                              String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
    }
}
