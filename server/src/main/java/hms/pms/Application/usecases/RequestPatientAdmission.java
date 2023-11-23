package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;

public interface RequestPatientAdmission {
    Boolean requestPatientAdmission(PatientAdmissionFromRequestListCreateDTO patientAdmissionRequest, DivisionInfoCreateDTO divisionInfo);
}
