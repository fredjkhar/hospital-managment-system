package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PatientCreateDTO;
import hms.pms.Application.usecases.RegisterPatient;
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
