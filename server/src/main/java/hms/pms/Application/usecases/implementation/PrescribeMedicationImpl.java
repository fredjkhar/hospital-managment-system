package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.Application.usecases.PrescribeMedication;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.prescription.facade.PrescriptionFacade;
import hms.pms.domain.prescription.factory.PrescriptionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class PrescribeMedicationImpl implements PrescribeMedication {

    private final PatientRepository patientRepository;
    private final PrescriptionFacade prescriptionFacade;

    @Autowired
    public PrescribeMedicationImpl(PatientRepository patientRepository, PrescriptionFacade prescriptionFacade) {
        this.patientRepository = patientRepository;
        this.prescriptionFacade = prescriptionFacade;
    }

    @Override
    public boolean prescribeMedication(UUID patientId, PrescriptionCreateDTO prescription) {
        Patient patient = patientRepository.find(patientId);

        if(patient != null) {
            return prescriptionFacade.createPrescription(patientId, prescription);
        }
        return false;
    }
}
