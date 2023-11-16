package hms.pms.domain.prescription.repository;
import java.util.UUID;

import hms.pms.domain.prescription.Entities.prescription;

public class prescriptionRepository {
    public prescription find(UUID id);

    public void save(prescription prescription);
}





