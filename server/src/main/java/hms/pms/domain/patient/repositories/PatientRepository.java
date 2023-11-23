package hms.pms.domain.patient.repositories;

import hms.pms.domain.patient.entities.Patient;

import java.util.UUID;

public interface PatientRepository {
    Patient find(UUID patientId);

    Patient find(String insuranceNumber);

    void save(Patient patient);
}
