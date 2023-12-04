package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.application.usecases.AdmitPatient;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AdmitPatientImpl implements AdmitPatient {
    private static final Logger logger = LogManager.getLogger(AdmitPatientImpl.class);

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
    public void admitPatient(UUID wardId, AdmissionCreateDTO patientAdmissionInfo) {
        UUID patientId = patientAdmissionInfo.getPatientId();

        Patient patient = patientRepository.find(patientId);
        if (patient == null) {
            logger.error("Failed to admit patient: Patient not found with ID " + patientId);
            return;
        }

        Ward ward = wardRepository.find(wardId);
        if (ward == null) {
            logger.error("Failed to admit patient: Ward not found with ID " + wardId);
            return;
        }

        if (!ward.getStatus().equals("incomplete")) {
            logger.error("Failed to admit patient: Ward status is not incomplete for Ward ID " + wardId);
            return;
        }

        wardFacade.admitPatient(wardId, patientAdmissionInfo);
        logger.info("Patient admission process initiated for patient ID " + patientId + " in ward ID " + wardId);
    }
}
