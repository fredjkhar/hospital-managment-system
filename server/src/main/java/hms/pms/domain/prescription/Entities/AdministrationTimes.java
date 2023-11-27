package hms.pms.domain.prescription.Entities;

import lombok.Getter;

@Getter
public class AdministrationTimes {
    private final String timeOfDay;
    private final int unitsAdministered;

    public AdministrationTimes(String timeOfDay, int unitsAdministered) {
        this.timeOfDay = timeOfDay;
        this.unitsAdministered = unitsAdministered;
    }
}
