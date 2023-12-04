package hms.pms.domain.ward.factories;

import hms.pms.application.dtos.queries.DischargeCreateDTO;
import hms.pms.domain.ward.entities.Discharge;

import java.util.UUID;

public interface DischargeFactory {
    Discharge createDischarge(DischargeCreateDTO dischargeInfo);
}
