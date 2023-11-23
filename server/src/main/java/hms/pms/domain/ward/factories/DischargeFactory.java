package hms.pms.domain.ward.factories;

import hms.pms.domain.ward.entities.Discharge;

import java.util.UUID;

public interface DischargeFactory {
    Discharge createDischarge(UUID patientId, String dischargeSummary);
}
