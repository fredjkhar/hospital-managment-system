package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;

import java.util.UUID;

public interface AdmitPatientFromRequestList {
    void admitPatientFromRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientFileAdmission);
}
