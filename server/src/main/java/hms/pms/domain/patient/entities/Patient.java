package hms.pms.domain.patient.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


public class Patient {
    private final UUID patientId;
    private final int insuranceNumber;
    private final String firstName;
    private final String lastName;
    private final int phoneNumber;
    private final Date dateOfBirth;
    private final char gender;
    private final String maritalStatus;
    private final UUID familyDoctor;
    private final ArrayList<UUID> prescriptionIds;
    private UUID admissionId;
    private UUID wardId;

    private Address address;
    private NextOfKin nextOfKin;
    
    public Patient(
            UUID patientId,
            int insuranceNumber,
            String firstName,
            String lastName,
            int phoneNumber,
            Date dateOfBirth,
            char gender,
            String maritalStatus,
            UUID familyDoctor,
            ArrayList<UUID> prescriptionIds,
            UUID admissionId,
            UUID wardId,
            Address address,
            NextOfKin nextOfKin,
          
    ) {
        this.patientId = patientId;
        this.insuranceNumber = insuranceNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.familyDoctor = familyDoctor;
        this.prescriptionIds = prescriptionIds;
        this.admissionId = admissionId;
        this.wardId = wardId;
        this.address = address;
        this.nextOfKin = nextOfKin;
    }

    public void updateInfo(PatientCreateDto patientInfo) {
        insuranceNumber = patientInfo.getinsuranceNumber();
        firstName = patientInfo.getLastName();
        lastName = patientInfo.getFirstName();
        phoneNumber = patientInfo.getTelephoneNumber();
        dateOfBirth = patientInfo.getDateOfBirth();
        gender = patientInfo.getGender();
        maritalStatus = patientInfo.getMaritalStatus();
        familyDoctor = patientInfo.getPersonalDoctor();
        address = patientInfo.getAddressInfo();
        nextOfKin = patientInfo.getNextOfKin();
    }

//     public boolean setWardAndAdmission(UUID wardIdIn, UUID admissionIdIn) {
//         admissionId = admissionIdIn;
//         wardId = wardIdIn;
//         return true;
//     }

//     public boolean isAdmitted() {
//         return admissionId != null;
//     }

//     public void removeWardFromPatient(DischargeInformationCreateDto dischargeInfo, DischargeInformationFactory dischargeInformationFactory) {
//         dischargeInformationFactory.createDischargeInformation(dischargeInfo);
//     }

//     public UUID[] getAdmissionIdAndWardId() {
//         if (admissionId != null && wardId != null) {
//             return new UUID[]{admissionId, wardId};
//         } else {
//             return null;
//         }
//     }

//     public boolean addPrescription(UUID prescId) {
//         prescriptionIds.add(prescId);
//         return true;
//     }
}

