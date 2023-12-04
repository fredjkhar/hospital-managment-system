package hms.pms.application.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressCreateDTO {
    private String street;
    private String city;
    private String country;
    private String postalCode;
}
