package hms.pms.domain.prescription.factory;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.domain.prescription.Entities.Prescription;

import java.util.UUID;

public interface PrescriptionFactory {
    Prescription createPrescription(PrescriptionCreateDTO prescriptionCreateDto);
}