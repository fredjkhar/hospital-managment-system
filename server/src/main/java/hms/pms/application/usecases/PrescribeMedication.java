package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;

import java.util.UUID;

public interface PrescribeMedication {
    void prescribeMedication(UUID patientId, PrescriptionCreateDTO prescription);
}
