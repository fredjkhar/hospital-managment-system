package hms.pms.domain.ward.factories;

import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;
import hms.pms.domain.ward.entities.AdmissionRequest;

public interface AdmissionRequestFactory {
    AdmissionRequest createAdmissionRequest(PatientAdmissionFromRequestListCreateDTO patientAdmissionRequestInfo);
}
