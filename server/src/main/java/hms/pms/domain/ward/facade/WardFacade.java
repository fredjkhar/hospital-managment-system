package hms.pms.domain.ward.facade;

import hms.pms.application.dtos.queries.PatientAdmissionCreateDTO;
import hms.pms.application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;
import hms.pms.application.dtos.queries.PatientDischargeCreateDTO;
import hms.pms.domain.ward.entities.Ward;

import java.util.UUID;


public interface WardFacade {
    Ward getWard(UUID wardId);

    void admitPatient(UUID wardId, PatientAdmissionCreateDTO patientAdmissionInfo);

    void admitPatientFromRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientAdmissionRequestInfo);

    void addPatientToRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientAdmissionInfo);

    void dischargePatient(UUID wardId, PatientDischargeCreateDTO patientDischargeInfo);
    
}
