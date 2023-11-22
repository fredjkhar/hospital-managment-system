package hms.pms.domain.patient.facade;

import hms.pms.Application.dtos.queries.PatientCreateDTO;

import java.util.UUID;

public interface PatientFacade {

    boolean createPatient(PatientCreateDTO patientInfo);

    boolean updatePatient(UUID patientID, PatientCreateDTO patientInfo);
}
