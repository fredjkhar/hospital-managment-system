package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;

import java.util.UUID;

public interface AdmitPatientFromRequestList {
    void admitPatientFromRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientFileAdmission);
}
