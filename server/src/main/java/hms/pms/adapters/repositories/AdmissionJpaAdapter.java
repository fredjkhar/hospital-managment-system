package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.AdmissionJpaConverter;
import hms.pms.domain.ward.entities.Admission;
import hms.pms.domain.ward.repositories.AdmissionRepository;
import hms.pms.infrastructure.jpa.dao.AdmissionJpaRepository;
import hms.pms.infrastructure.jpa.entities.ward.AdmissionJpaEntity;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"admissions"})
public class AdmissionJpaAdapter implements AdmissionRepository {
    private final AdmissionJpaRepository admissionRepository;
    private final AdmissionJpaConverter converter = Mappers.getMapper(AdmissionJpaConverter.class);

    @Autowired
    public AdmissionJpaAdapter(AdmissionJpaRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    @Cacheable(key = "#admissionId")
    @Transactional
    @Override
    public Admission find(UUID admissionId) {
        return admissionRepository.findById(admissionId).map(converter::toModel).orElse(null);
    }

    @CachePut(key = "#admission.getId()")
    @Override
    public void save(Admission admission) {
        AdmissionJpaEntity admissionJpa = converter.toJpa(admission);
        admissionRepository.save(admissionJpa);
    }
}
