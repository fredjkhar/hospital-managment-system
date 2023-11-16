package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientAdmissionRequestCreateDTO;
import hms.pms.Application.dtos.queries.WardInfoCreateDTO;


public interface RequestPatientAdmission {
    Boolean requestPatientAdmission(PatientAdmissionRequestCreateDTO patientAdmissionRequest, WardInfoCreateDTO wardInfo);
}
