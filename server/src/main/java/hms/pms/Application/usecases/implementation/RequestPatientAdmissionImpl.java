package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PatientAdmissionFromRequestListCreateDTO;
import hms.pms.Application.usecases.RequestPatientAdmission;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RequestPatientAdmissionImpl implements RequestPatientAdmission {

    private static final Logger logger = LogManager.getLogger(RequestPatientAdmissionImpl.class);

    private final WardRepository wardRepository;
    private final WardFacade wardFacade;

    @Autowired
    public RequestPatientAdmissionImpl(WardRepository wardRepository, WardFacade wardFacade) {
        this.wardRepository = wardRepository;
        this.wardFacade = wardFacade;
    }

    @Override
    public void requestPatientAdmission(PatientAdmissionFromRequestListCreateDTO patientAdmissionRequest, UUID wardId) {
        Ward ward = wardRepository.find(wardId);

        if (ward == null) {
            logger.error("Ward not found for ID " + wardId);
            return;
        }

        wardFacade.addPatientToRequestList(wardId, patientAdmissionRequest);
    }
}
