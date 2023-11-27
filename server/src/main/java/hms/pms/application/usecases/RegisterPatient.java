package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientCreateDTO;

public interface RegisterPatient {
    void registerPatient(PatientCreateDTO patientInfo);
}
