package hms.pms.domain.prescription.repository;

import hms.pms.domain.prescription.Entities.Prescription;

import java.util.UUID;

public interface PrescriptionRepository {
    public Prescription find(UUID id);
    public void save(Prescription prescription);
}





