package hms.pms.domain.prescription.facade;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;

import java.util.UUID;

public interface PrescriptionFacade {
    void createPrescription(UUID patientId, PrescriptionCreateDTO prescriptionInfo);

    void updatePrescription(UUID prescriptionId, UUID patientId, PrescriptionCreateDTO prescriptionInfo);
}