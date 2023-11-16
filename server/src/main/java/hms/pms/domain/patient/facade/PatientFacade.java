package hms.pms.domain.patient.facade;

import hms.pms.application.dtos.queries.PatientCreateDTO;
import hms.pms.application.dtos.queries.PatientDischargeCreateDTO;

import java.util.UUID;

public interface PatientFacade {

    UUID createPatient(PatientCreateDto patientInfo);
    boolean updatePatient(UUID patientId, PatientCreateDto patientInfo);
    boolean admitPatient(UUID patientId, UUID divisionId, UUID admissionId);
    boolean isAdmitted(UUID patientId);
    boolean removeDivisionFromPatient(UUID patientId, DischargeInformationCreateDto dischargeInfo);
    UUID[] getAdmIdAndDivId(UUID patientId);
    boolean addPrescription(UUID patientId, UUID prescId);
}
