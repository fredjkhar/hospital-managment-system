package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;

import java.util.UUID;

public interface RequestPatientAdmission {
    void requestPatientAdmission(PatientAdmissionFromRequestListCreateDTO patientAdmissionRequest, UUID wardId);
}
