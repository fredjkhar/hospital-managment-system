package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.DischargeCreateDTO;

import java.util.UUID;

public interface DischargePatient {
    void dischargePatient(UUID wardId, DischargeCreateDTO dischargeInfo);
}
