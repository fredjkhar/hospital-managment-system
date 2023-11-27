package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientAdmissionCreateDTO;

import java.util.UUID;


public interface AdmitPatient {
    void admitPatient(UUID wardId, PatientAdmissionCreateDTO patientFileAdmission);
}
