package hms.pms.domain.ward.repositories;

import hms.pms.domain.ward.entities.Admission;

import java.util.UUID;

public interface AdmissionRepository {
    Admission find(UUID admissionId);

    void save(Admission admission);
}
