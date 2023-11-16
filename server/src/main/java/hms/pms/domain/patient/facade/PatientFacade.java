package hms.pms.domain.patient.facade;

import java.util.UUID;


public interface PatientFacade {

    UUID createPatient(PatientCreateDto patientInfo);
    boolean updatePatient(UUID patientId, PatientCreateDto patientInfo);
    boolean admitPatient(UUID patientId, UUID wardId, UUID admissionId);
    boolean isAdmitted(UUID patientId);
    boolean removeWardFromPatient(UUID patientId, DischargeInformationCreateDto dischargeInfo);
    UUID[] getAdmIdAndDivId(UUID patientId);
    boolean addPrescription(UUID patientId, UUID prescId);
}
