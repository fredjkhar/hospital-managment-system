package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.DischargeCreateDTO;
import hms.pms.application.usecases.DischargePatient;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class DischargePatientImpl implements DischargePatient {

    private static final Logger logger = LogManager.getLogger(DischargePatientImpl.class);

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
    public void dischargePatient(UUID wardId, DischargeCreateDTO patientDischargeInfo) {
        UUID patientId = patientDischargeInfo.getPatientId();

        Patient patient = patientRepository.find(patientId);
        if (patient == null) {
            logger.error("Failed to discharge patient: Patient not found with ID " + patientId);
            return;
        }

        Ward ward = wardRepository.find(wardId);
        if (ward == null) {
            logger.error("Failed to discharge patient: Ward not found with ID " + wardId);
            return;
        }

        UUID roomNbr = patientDischargeInfo.getRoomNbr();
        UUID bedNbr = patientDischargeInfo.getBedNbr();
        if (roomNbr == null || bedNbr == null) {
            logger.error("Failed to discharge patient: Room or bed number is null");
            return;
        }

        wardFacade.dischargePatient(wardId, patientDischargeInfo);
        logger.info("Patient discharge process initiated for patient ID " + patientId + " in ward ID " + wardId);
    }
}
