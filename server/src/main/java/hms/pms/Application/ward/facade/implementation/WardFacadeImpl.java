package hms.pms.Application.ward.facade.implementation;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;
import hms.pms.Application.ward.entities.Admission;
import hms.pms.Application.ward.entities.Ward;
import hms.pms.Application.ward.facade.WardFacade;
import hms.pms.Application.ward.factories.AdmissionFactory;
import hms.pms.Application.ward.repositories.WardRepository;
import java.util.UUID;



public class WardFacadeImpl implements WardFacade {
    private final WardRepository wardRepository;
    private final AdmissionFactory admissionFactory;

    public WardFacadeImpl(WardRepository wardRepository, AdmissionFactory admissionFactory) {
        this.wardRepository = wardRepository;
        this.admissionFactory = admissionFactory;
    }

    @Override
    public Ward getWard(UUID wardId) {
        return wardRepository.find(wardId);
    }

    @Override
    public boolean admitPatient(UUID wardId, PatientAdmissionCreateTDO admissionInfo) {
        Ward ward = getWard(wardId);
        if (ward.getStatus() == Ward.STATUS_COMPLETE) {
            return false;
        }
        Admission admission = admissionFactory.createAdmission(admissionInfo);
        ward.admitPatient(admission);
        return true;
    }
    
}
