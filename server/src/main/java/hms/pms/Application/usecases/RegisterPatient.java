package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientCreateDTO;

public interface RegisterPatient {
    boolean registerPatient(PatientCreateDTO patientInfo);
}
