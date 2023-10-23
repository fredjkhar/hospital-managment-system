package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;

import java.util.UUID;

public interface PrescribeMedication {
    Boolean prescribeMedication(PrescriptionCreateDTO prescription, UUID patientId);
}
