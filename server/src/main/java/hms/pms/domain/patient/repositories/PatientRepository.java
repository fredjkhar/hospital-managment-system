package hms.pms.domain.patient.repositories;

import hms.pms.domain.patient.entities.Patient;

import java.util.UUID;

public interface PatientRepository {
    Patient find(UUID patientId);
    void save(Patient patient);
}
