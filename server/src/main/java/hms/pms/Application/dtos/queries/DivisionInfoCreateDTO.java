package hms.pms.Application.dtos.queries;

public class WardInfoCreateDTO {
    private String wardIdentifier;
    private String wardName;
    private ChargeNurse chargeNurse;
    private String location;
    private int totalNumberOfBeds;
    private int currentNumberOfBeds;
    private String telephoneExtensionNumber;
    private Boolean statusOfWard;

    private static class ChargeNurse {
        private String name;
        private String telephoneExtension;
        private String bipperExtension;
    }
}

