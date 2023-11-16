package hms.pms.domain.prescription.factory;

import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.domain.prescription.Entities.prescription;
import java.util.*;

public interface prescriptionFactory {
    prescription createPrescription(UUID patientId, PrescriptionCreateDTO prescriptionCreateDto);
}