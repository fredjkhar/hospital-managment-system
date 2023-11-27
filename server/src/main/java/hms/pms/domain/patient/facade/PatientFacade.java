package hms.pms.domain.patient.facade;

import hms.pms.application.dtos.queries.PatientCreateDTO;

import java.util.UUID;

public interface PatientFacade {

    void createPatient(PatientCreateDTO patientInfo);

    void updatePatient(UUID patientID, PatientCreateDTO patientInfo);
}
