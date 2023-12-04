package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.application.usecases.AdmitPatientFromRequestList;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class AdmitPatientFromRequestListImpl implements AdmitPatientFromRequestList {

    private static final Logger logger = LogManager.getLogger(AdmitPatientFromRequestListImpl.class);

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
    public void admitPatientFromRequestList(UUID wardId, AdmissionRequestCreateDTO patientAdmissionRequestInfo) {
        UUID patientId = patientAdmissionRequestInfo.getPatientId();

        Patient patient = patientRepository.find(patientId);
        if (patient == null) {
            logger.error("Failed to admit patient from request list: Patient not found with ID " + patientId);
            return;
        }

        Ward ward = wardRepository.find(wardId);
        if (ward == null) {
            logger.error("Failed to admit patient from request list: Ward not found with ID " + wardId);
            return;
        }

        wardFacade.admitPatientFromRequestList(wardId, patientAdmissionRequestInfo);
        logger.info("Patient admission request processed for patient ID " + patientId + " in ward ID " + wardId);
    }
}
