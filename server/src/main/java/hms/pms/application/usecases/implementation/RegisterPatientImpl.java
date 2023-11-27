package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.PatientCreateDTO;
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
    public void registerPatient(PatientCreateDTO patientInfo) {
        patientFacade.createPatient(patientInfo);
    }
}
