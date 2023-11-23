package hms.pms.Application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DivisionInfoCreateDTO {
    private String divisionIdentifier;
    private String divisionName;
    private ChargeNurse chargeNurse;
    private String location;
    private int totalNumberOfBeds;
    private int currentNumberOfBeds;
    private String telephoneExtensionNumber;
    private Boolean statusOfDivision;

    public DivisionInfoCreateDTO(String divisionIdentifier, String divisionName,
                                 ChargeNurse chargeNurse, String location,
                                 int totalNumberOfBeds, int currentNumberOfBeds,
                                 String telephoneExtensionNumber, Boolean statusOfDivision) {
        this.divisionIdentifier = divisionIdentifier;
        this.divisionName = divisionName;
        this.chargeNurse = chargeNurse;
        this.location = location;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.currentNumberOfBeds = currentNumberOfBeds;
        this.telephoneExtensionNumber = telephoneExtensionNumber;
        this.statusOfDivision = statusOfDivision;
    }

    public static class ChargeNurse {
        private String name;
        private String telephoneExtension;
        private String bipperExtension;
    }
}

