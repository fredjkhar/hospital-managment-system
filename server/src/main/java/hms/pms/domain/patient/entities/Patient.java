package hms.pms.domain.patient.entities;

import hms.pms.application.dtos.queries.PatientCreateDTO;
import hms.pms.application.dtos.queries.PatientDischargeCreateDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private UUID divisionId;

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
            UUID divisionId,
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
        this.divisionId = divisionId;
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

//     public boolean setDivisionAndAdmission(UUID divisionIdIn, UUID admissionIdIn) {
//         admissionId = admissionIdIn;
//         divisionId = divisionIdIn;
//         return true;
//     }

//     public boolean isAdmitted() {
//         return admissionId != null;
//     }

//     public void removeDivisionFromPatient(DischargeInformationCreateDto dischargeInfo, DischargeInformationFactory dischargeInformationFactory) {
//         dischargeInformationFactory.createDischargeInformation(dischargeInfo);
//     }

//     public UUID[] getAdmissionIdAndDivisionId() {
//         if (admissionId != null && divisionId != null) {
//             return new UUID[]{admissionId, divisionId};
//         } else {
//             return null;
//         }
//     }

//     public boolean addPrescription(UUID prescId) {
//         prescriptionIds.add(prescId);
//         return true;
//     }
}

