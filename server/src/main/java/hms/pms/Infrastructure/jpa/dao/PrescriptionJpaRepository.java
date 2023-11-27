package hms.pms.Infrastructure.jpa.dao;

import hms.pms.domain.prescription.Entities.Prescription;
import hms.pms.domain.prescription.repository.PrescriptionRepository;

import java.util.UUID;

public class PrescriptionJpaRepository implements PrescriptionRepository {
    @Override
    public Prescription find(UUID id) {
        return null;
    }

    @Override
    public void save(Prescription prescription) {

    }
}
