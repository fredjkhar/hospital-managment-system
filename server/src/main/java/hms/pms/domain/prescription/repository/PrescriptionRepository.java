package hms.pms.domain.prescription.repository;
import java.util.UUID;

import hms.pms.domain.prescription.Entities.Prescription;

public interface PrescriptionRepository {
    public Prescription find(UUID id);

    public void save(Prescription prescription);
}





