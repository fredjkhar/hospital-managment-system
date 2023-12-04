package hms.pms.application.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdministrationTimeCreateDTO {
    private String timeOfDay;
    private int unitsAdministered;
}
