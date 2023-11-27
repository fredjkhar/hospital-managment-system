package hms.pms.domain.patient.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import hms.pms.Application.dtos.queries.AddressCreateDTO;
import hms.pms.Application.dtos.queries.NextOfKinCreateDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Patient {
    private UUID patientId;
    private String insuranceNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private char gender;
    private String maritalStatus;
    private UUID externalDoctorId;
    private ArrayList<UUID> prescriptions;
    private Address address;
    private NextOfKin nextOfKin;
    private String primaryChargeNurseId;

    public Patient(String insuranceNumber, String firstName, String lastName,
                   String phoneNumber, Date dateOfBirth, char gender,
                   String maritalStatus, UUID externalDoctorId,
                   String primaryChargeNurseId) {
        this.patientId = UUID.randomUUID();
        this.insuranceNumber = insuranceNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.externalDoctorId = externalDoctorId;
        this.primaryChargeNurseId = primaryChargeNurseId;
        this.prescriptions = new ArrayList<>();
    }

    public void update(Patient patient) {
        this.firstName = patient.getFirstName();
        this.lastName = patient.getLastName();
        this.phoneNumber = patient.getPhoneNumber();
        this.address = patient.getAddress();
        this.nextOfKin = patient.getNextOfKin();
        this.primaryChargeNurseId = patient.getPrimaryChargeNurseId();
    }

    public void setAddress(AddressCreateDTO addressInfo) {
        this.address = new Address(addressInfo.getStreet(), addressInfo.getCity(),
                addressInfo.getCountry(), addressInfo.getPostalCode());
    }

    public void setNextOfKin(NextOfKinCreateDTO nextOfKinInfo) {
        this.nextOfKin = new NextOfKin(nextOfKinInfo.getFirstName(), nextOfKinInfo.getLastName(),
                nextOfKinInfo.getRelationship(), nextOfKinInfo.getPhoneNumber());
        this.nextOfKin.setAddress(nextOfKinInfo.getAddress());
    }

    public void addPrescription(UUID prescriptionId) {
        prescriptions.add(prescriptionId);
    }
}
