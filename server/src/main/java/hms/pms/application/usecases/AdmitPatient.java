package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;

import java.util.UUID;


public interface AdmitPatient {
    void admitPatient(UUID wardId, AdmissionCreateDTO patientFileAdmission);
}
