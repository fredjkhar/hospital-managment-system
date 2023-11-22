package hms.pms.domain.prescription.facade;

import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.domain.prescription.Entities.Prescription;

import java.util.UUID;

public interface PrescriptionFacade {
    boolean createPrescription(UUID patientId, PrescriptionCreateDTO prescriptionInfo);
    boolean updatePrescription(UUID prescriptionId, UUID patientId, PrescriptionCreateDTO prescriptionInfo);
}