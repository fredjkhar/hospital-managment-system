package hms.pms.Application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressCreateDTO {
    private String street;
    private String city;
    private String country;
    private String postalCode;

    public AddressCreateDTO(String street, String city,
                            String country, String postalCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }
}
