package hms.pms.domain.patient.entities;

public class NextOfKin {
    private String firstName;
    private String lastName;
    private String relationshipToPatient;
    private int phoneNumber;

    public NextOfKin(String firstName, String lastName, String relationshipToPatient, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationshipToPatient = relationshipToPatient;
        this.phoneNumber = phoneNumber;
    }

}
