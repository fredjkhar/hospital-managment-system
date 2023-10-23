package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientFileCreateDTO;

import java.util.UUID;

public interface RegisterPatient {
    UUID registerPatient(PatientFileCreateDTO patientInfo);
}
