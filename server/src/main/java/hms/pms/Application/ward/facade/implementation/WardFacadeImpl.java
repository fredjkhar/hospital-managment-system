package hms.pms.Application.ward.facade.implementation;

import hms.pms.Application.ward.entities.Ward;
import hms.pms.Application.ward.facade.WardFacade;
import hms.pms.Application.ward.repositories.WardRepository;
import java.util.UUID;



public class WardFacadeImpl implements WardFacade {
    static WardRepository wardRepository;

    @Override
    public Ward getWard(UUID wardId) {
        return wardRepository.find(wardId);
    }

    @Override
    public boolean admitPatient(UUID wardId, UUID patientId, int roomNumber, int bedNumber) {
        Ward ward = getWard(wardId);
        if (ward.getStatus() == Ward.STATUS_COMPLETE) {
            return false;
        }
        return true;
    }
    
}
