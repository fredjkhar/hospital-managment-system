package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;

public interface RegisterPatient {
    void registerPatient(PatientInfoCreateDTO patientInfo);
}
