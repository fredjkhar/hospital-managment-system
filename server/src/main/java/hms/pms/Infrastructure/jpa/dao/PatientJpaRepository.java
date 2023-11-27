package hms.pms.Infrastructure.jpa.dao;

import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;

import java.util.UUID;

public class PatientJpaRepository implements PatientRepository {
    @Override
    public Patient find(UUID patientId) {
        return null;
    }

    @Override
    public Patient find(String insuranceNumber) {
        return null;
    }

    @Override
    public void save(Patient patient) {

    }
}
