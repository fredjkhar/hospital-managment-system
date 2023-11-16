package hms.pms.Application.ward.facade;
import hms.pms.Application.ward.entities.Ward;
import java.util.UUID;


public interface WardFacade {
    
    public Ward getWard(UUID wardId);
    public boolean admitPatient(UUID wardId, UUID patientId, int roomNumber, int bedNumber);
    
}
