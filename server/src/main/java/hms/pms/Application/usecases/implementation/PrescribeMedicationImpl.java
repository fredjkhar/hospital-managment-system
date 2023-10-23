package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.Application.usecases.PrescribeMedication;

import java.util.UUID;

public class PrescribeMedicationImpl implements PrescribeMedication {
    @Override
    public Boolean prescribeMedication(PrescriptionCreateDTO prescription , UUID patientId) {
        //TODO  Implement the method
        return null;
    }
}
