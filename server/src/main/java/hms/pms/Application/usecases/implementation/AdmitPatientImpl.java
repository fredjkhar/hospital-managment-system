package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;
import hms.pms.Application.usecases.AdmitPatient;
import hms.pms.Application.ward.entities.Ward;
import hms.pms.Application.ward.facade.WardFacade;
import java.util.UUID;



public class AdmitPatientImpl implements AdmitPatient {

    private final WardFacade wardFacade;

    @Autowired
    public AdmitPatientImpl(WardFacade wardFacade) {
        this.wardFacade = wardFacade;
    }

    @Override
    public Boolean admitPatient(PatientAdmissionCreateTDO patientFileAdmission, UUID wardId) {
        Ward ward = wardFacade.getWard(wardId);
        if (ward.getStatus().equals(Ward.STATUS_INCOMPLETE)) {
            return wardFacade.admitPatient(wardId, patientFileAdmission);
        }
        return false;
    }
}
