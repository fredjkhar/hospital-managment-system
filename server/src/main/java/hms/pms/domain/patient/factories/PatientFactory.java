package hms.pms.domain.patient.factories;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;
import hms.pms.domain.patient.entities.Patient;

public interface PatientFactory {
    Patient createPatient(PatientInfoCreateDTO patientInfo);
}
