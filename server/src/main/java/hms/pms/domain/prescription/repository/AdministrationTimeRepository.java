package hms.pms.domain.prescription.repository;

import hms.pms.domain.prescription.Entities.AdministrationTime;

import java.util.UUID;

public interface AdministrationTimeRepository {
    AdministrationTime find(UUID id);

    void save(AdministrationTime administrationTime);
}
