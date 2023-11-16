package hms.pms.contracts.testStubs.repositories;

import your.domain.patient.entities.Patient;
import your.domain.patient.repositories.PatientRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PatientRepositoryStub implements PatientRepository {
    private final Map<String, Patient> patients = new HashMap<>();

    @Override
    public Patient save(Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    @Override
    public Optional<Patient> findById(String patientId) {
        return Optional.ofNullable(patients.get(patientId));
    }
}
