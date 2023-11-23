package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateDTO;
import hms.pms.Application.usecases.AdmitPatient;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;



public class AdmitPatientImpl implements AdmitPatient {
    private final PatientRepository patientRepository;
    private final WardRepository wardRepository;
    private final WardFacade wardFacade;

    @Autowired
    public AdmitPatientImpl(PatientRepository patientRepository, WardRepository wardRepository, WardFacade wardFacade) {
        this.patientRepository = patientRepository;
        this.wardRepository = wardRepository;
        this.wardFacade = wardFacade;
    }

    @Override
    public boolean admitPatient(UUID wardId, PatientAdmissionCreateDTO patientAdmissionInfo) {
        UUID roomNbr = patientAdmissionInfo.getRoomNumber();
        UUID bedNbr = patientAdmissionInfo.getBedNumber();
        UUID patientId = patientAdmissionInfo.getPatientId();

        Patient patient = patientRepository.find(patientId);
        Ward ward = wardRepository.find(wardId);

        if (ward != null && patient != null && ward.getStatus().equals("incomplete") &&
                roomNbr != null && bedNbr != null) {
            return wardFacade.admitPatient(wardId, patientAdmissionInfo);
        }
        return false;
    }
}
