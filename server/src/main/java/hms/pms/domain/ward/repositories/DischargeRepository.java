package hms.pms.domain.ward.repositories;

import hms.pms.domain.ward.entities.Discharge;

import java.util.UUID;

public interface DischargeRepository {
    Discharge find(UUID dischargeId);

    void save(Discharge discharge);
}
