package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientAdmissionRequestCreateDTO;
import hms.pms.Application.usecases.RequestPatientAdmission;

import java.util.UUID;

public class RequestPatientAdmissionImpl implements RequestPatientAdmission {
    @Override
    public Boolean requestPatientAdmission(UUID patientId, PatientAdmissionRequestCreateDTO patientAdmissionRequest, DivisionInfoCreateDTO divisionInfo) {
        //TODO  Implement the method
        return null;
    }
}
