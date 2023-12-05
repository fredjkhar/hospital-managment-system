package hms.pms.domain.patient.facade;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;

import java.util.UUID;

public interface PatientFacade {

    void createPatient(PatientInfoCreateDTO patientInfo);

    void updatePatient(UUID patientID, PatientInfoCreateDTO patientInfo);
}
