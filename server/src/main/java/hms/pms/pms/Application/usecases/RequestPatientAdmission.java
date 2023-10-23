package hms.pms.pms.Application.usecases;

import hms.pms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.pms.Application.dtos.queries.PatientAdmissionRequestCreateDTO;

import java.util.UUID;

public interface RequestPatientAdmission {
    Boolean requestPatientAdmission(UUID patientId, PatientAdmissionRequestCreateDTO patientAdmissionRequest, DivisionInfoCreateDTO divisionInfo);
}
