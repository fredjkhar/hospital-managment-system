package hms.pms.contracts.testStubs.repositories;

import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.staff.entities.Staff;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class PatientRepositoryStub implements PatientRepository {
    private HashMap<UUID, Patient> patients = new HashMap<>();

    @Override
    public Patient find(UUID patientId) {
        return patients.get(patientId);
    }

    @Override
    public Patient find(String insuranceNumber) {
        for (Map.Entry<UUID, Patient> entry : patients.entrySet()) {
            UUID patientId = entry.getKey();
            Patient patient = entry.getValue();
            if (Objects.equals(patient.getInsuranceNumber(), insuranceNumber))
                return patient;
        }
        return null;
    }

    @Override
    public void save(Patient patient) {
        patients.put(patient.getPatientId(), patient);
    }
}
