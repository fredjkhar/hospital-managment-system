package hms.pms.domain.prescription.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AdministrationTime {
    private final UUID id;
    private final String timeOfDay;
    private final int unitsAdministered;
}
