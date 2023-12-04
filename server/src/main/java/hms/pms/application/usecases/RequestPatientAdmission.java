package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;

import java.util.UUID;

public interface RequestPatientAdmission {
    void requestPatientAdmission(AdmissionRequestCreateDTO patientAdmissionRequest, UUID wardId);
}
