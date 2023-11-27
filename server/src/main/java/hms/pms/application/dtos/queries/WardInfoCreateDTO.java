package hms.pms.application.dtos.queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WardInfoCreateDTO {
    private String divisionIdentifier;
    private String divisionName;
    private ChargeNurse chargeNurse;
    private String location;
    private int totalNumberOfBeds;
    private int currentNumberOfBeds;
    private String telephoneExtensionNumber;
    private Boolean statusOfDivision;

    public WardInfoCreateDTO(String divisionIdentifier, String divisionName,
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

