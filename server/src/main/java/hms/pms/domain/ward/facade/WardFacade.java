package hms.pms.domain.ward.facade;
import hms.pms.Application.dtos.queries.PatientAdmissionCreateDTO;
import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;
import hms.pms.Application.dtos.queries.PatientDischargeCreateDTO;
import hms.pms.domain.ward.entities.Ward;
import java.util.UUID;


public interface WardFacade {
    
    Ward getWard(UUID wardId);
    boolean admitPatient(UUID wardId, PatientAdmissionCreateDTO patientAdmissionInfo);

    boolean admitPatientFromRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientAdmissionRequestInfo);
    boolean dischargePatient(UUID wardId, PatientDischargeCreateDTO patientDischargeInfo);
    
}
