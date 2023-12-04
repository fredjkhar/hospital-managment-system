package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;
import hms.pms.application.usecases.RegisterPatient;
import hms.pms.domain.patient.facade.PatientFacade;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterPatientImpl implements RegisterPatient {

    private final PatientFacade patientFacade;

    @Autowired
    public RegisterPatientImpl(PatientFacade patientFacade) {
        this.patientFacade = patientFacade;
    }

    @Override
    public void registerPatient(PatientInfoCreateDTO patientInfo) {
        patientFacade.createPatient(patientInfo);
    }
}
