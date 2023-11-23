package hms.pms.domain.patient.factories;

import hms.pms.Application.dtos.queries.PatientCreateDTO;
import hms.pms.domain.patient.entities.Patient;

public interface PatientFactory {
    Patient createPatient(PatientCreateDTO patientInfo);
}
