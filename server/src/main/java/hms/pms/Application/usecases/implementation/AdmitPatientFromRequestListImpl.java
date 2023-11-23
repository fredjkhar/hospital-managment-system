package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;
import hms.pms.Application.usecases.AdmitPatientFromRequestList;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AdmitPatientFromRequestListImpl implements AdmitPatientFromRequestList {

    private final PatientRepository patientRepository;
    private final WardRepository wardRepository;
    private final WardFacade wardFacade;

    @Autowired
    public AdmitPatientFromRequestListImpl(PatientRepository patientRepository, WardRepository wardRepository, WardFacade wardFacade) {
        this.patientRepository = patientRepository;
        this.wardRepository = wardRepository;
        this.wardFacade = wardFacade;
    }

    @Override
    public boolean admitPatientFromRequestList(UUID wardId, PatientAdmissionFromRequestListCreateDTO patientAdmissionRequestInfo) {
        UUID patientId = patientAdmissionRequestInfo.getPatientId();

        Patient patient = patientRepository.find(patientId);
        Ward ward = wardRepository.find(wardId);

        if (ward != null && patient != null) {
            return wardFacade.admitPatientFromRequestList(wardId, patientAdmissionRequestInfo);
        }
        return false;
    }
}
