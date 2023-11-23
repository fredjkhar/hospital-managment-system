package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PatientDischargeCreateDTO;
import hms.pms.Application.usecases.DischargePatient;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class DischargePatientImpl implements DischargePatient {

    private final PatientRepository patientRepository;
    private final WardRepository wardRepository;
    private final WardFacade wardFacade;

    @Autowired
    public DischargePatientImpl(PatientRepository patientRepository, WardRepository wardRepository, WardFacade wardFacade) {
        this.patientRepository = patientRepository;
        this.wardRepository = wardRepository;
        this.wardFacade = wardFacade;
    }

    @Override
    public boolean dischargePatient(UUID wardId, PatientDischargeCreateDTO patientDischargeInfo) {
        UUID roomNbr = patientDischargeInfo.getRoomNbr();
        UUID bedNbr = patientDischargeInfo.getBedNbr();
        UUID patientId = patientDischargeInfo.getPatientId();

        Patient patient = patientRepository.find(patientId);
        Ward ward = wardRepository.find(wardId);


        if (ward != null && patient != null && roomNbr != null && bedNbr != null) {
            return wardFacade.dischargePatient(wardId, patientDischargeInfo);
        }
        return false;
    }
}
