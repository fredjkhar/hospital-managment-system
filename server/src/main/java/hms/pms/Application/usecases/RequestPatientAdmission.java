package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientAdmissionRequestCreateDTO;

import java.util.UUID;

public interface RequestPatientAdmission {
    Boolean requestPatientAdmission(PatientAdmissionRequestCreateDTO patientAdmissionRequest, DivisionInfoCreateDTO divisionInfo);
}
