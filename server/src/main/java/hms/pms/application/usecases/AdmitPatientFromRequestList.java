package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;

import java.util.UUID;

public interface AdmitPatientFromRequestList {
    void admitPatientFromRequestList(UUID wardId, AdmissionRequestCreateDTO patientFileAdmission);
}
