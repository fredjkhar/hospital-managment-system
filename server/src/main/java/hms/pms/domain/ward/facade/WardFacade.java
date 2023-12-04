package hms.pms.domain.ward.facade;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.application.dtos.queries.DischargeCreateDTO;
import hms.pms.domain.ward.entities.Ward;

import java.util.UUID;


public interface WardFacade {
    Ward getWard(UUID wardId);

    void admitPatient(UUID wardId, AdmissionCreateDTO patientAdmissionInfo);

    void admitPatientFromRequestList(UUID wardId, AdmissionRequestCreateDTO patientAdmissionRequestInfo);

    void addPatientToRequestList(UUID wardId, AdmissionRequestCreateDTO patientAdmissionInfo);

    void dischargePatient(UUID wardId, DischargeCreateDTO patientDischargeInfo);
    
}
