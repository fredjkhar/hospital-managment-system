package hms.pms.domain.prescription.facade;

import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.domain.prescription.Entities.*;

public interface prescriptionFacade {
    boolean createPrescription(PrescriptionCreateDTO prescriptionInfo);
    boolean updatePrescription(String prescriptionId, PrescriptionCreateDTO prescriptionInfo);
}