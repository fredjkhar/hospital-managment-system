package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.PatientJpaConverter;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.infrastructure.jpa.dao.PatientJpaRepository;
import hms.pms.infrastructure.jpa.entities.patient.PatientJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@CacheConfig(cacheNames = {"patients"})
public class PatientJpaAdapter implements PatientRepository {
    private final PatientJpaRepository patientJpaRepository;
    private final PatientJpaConverter converter = Mappers.getMapper(PatientJpaConverter.class);

    @Autowired
    public PatientJpaAdapter(PatientJpaRepository patientJpaRepository) {
        this.patientJpaRepository = patientJpaRepository;
    }

    @Cacheable(key = "#patientId")
    @Transactional
    @Override
    public Patient find(UUID patientId) {
        return patientJpaRepository.findById(patientId)
                .map(converter::toModel)
                .orElse(null);
    }

    @Cacheable(key = "#insuranceNumber")
    @Transactional
    @Override
    public Patient find(String insuranceNumber) {
        return patientJpaRepository.findByInsuranceNumber(insuranceNumber)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#patient.getId()")
    @Override
    public void save(Patient patient) {
        PatientJpaEntity patientJpa = converter.toJpa(patient);
        patientJpaRepository.save(patientJpa);
    }

    @Override
    public List<Patient> findAll() {
        return patientJpaRepository.findAll().stream()
                .map(converter::toModel)
                .collect(Collectors.toList());
    }

}
