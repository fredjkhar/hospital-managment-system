package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.domain.prescription.Entities.Prescription;

public interface PrescriptionDTOConverter {
    Prescription covertDto(PrescriptionCreateDTO prescriptionInfo);
}
