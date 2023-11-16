package hms.pms.domain.patient.factories;

import hms.pms.application.dtos.queries.PatientCreateDTO;
import hms.pms.domain.patient.entities.Patient;

public interface PatientFactory {
    Patient createPatient(PatientCreateDto patientInfo);
}
