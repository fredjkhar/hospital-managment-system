package hms.pms.Application.dtos.queries;

public class DivisionInfoCreateDTO {
    private String divisionIdentifier;
    private String divisionName;
    private ChargeNurse chargeNurse;
    private String location;
    private int totalNumberOfBeds;
    private int currentNumberOfBeds;
    private String telephoneExtensionNumber;
    private Boolean statusOfDivision;

    private static class ChargeNurse {
        private String name;
        private String telephoneExtension;
        private String bipperExtension;
    }
}

