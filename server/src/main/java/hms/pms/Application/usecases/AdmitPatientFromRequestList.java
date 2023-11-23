package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;

import java.util.UUID;

public interface AdmitPatientFromRequestList {
    boolean admitPatientFromRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientFileAdmission);
}
