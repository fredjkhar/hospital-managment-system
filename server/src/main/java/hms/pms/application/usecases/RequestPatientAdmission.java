package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;

import java.util.UUID;

public interface RequestPatientAdmission {
    void requestPatientAdmission(PatientAdmissionFromRequestListCreateDTO patientAdmissionRequest, UUID wardId);
}
