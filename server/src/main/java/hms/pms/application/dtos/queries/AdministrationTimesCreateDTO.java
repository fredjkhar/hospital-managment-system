package hms.pms.application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministrationTimesCreateDTO {
    private String timeOfDay;
    private int unitsAdministered;

    public AdministrationTimesCreateDTO(String timeOfDay, int unitsAdministered) {
        this.timeOfDay = timeOfDay;
        this.unitsAdministered = unitsAdministered;
    }
}
