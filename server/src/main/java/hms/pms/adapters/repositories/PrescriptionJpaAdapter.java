package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.PrescriptionJpaConverter;
import hms.pms.domain.prescription.Entities.Prescription;
import hms.pms.domain.prescription.repository.PrescriptionRepository;
import hms.pms.infrastructure.jpa.dao.PrescriptionJpaRepository;
import hms.pms.infrastructure.jpa.entities.prescription.PrescriptionJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"prescriptions"})
public class PrescriptionJpaAdapter implements PrescriptionRepository {
    private final PrescriptionJpaRepository prescriptionRepository;
    private final PrescriptionJpaConverter converter = Mappers.getMapper(PrescriptionJpaConverter.class);

    @Autowired
    public PrescriptionJpaAdapter(PrescriptionJpaRepository prescriptionJpaRepository) {
        this.prescriptionRepository = prescriptionJpaRepository;
    }

    @Cacheable(key = "#id")
    @Transactional
    @Override
    public Prescription find(UUID id) {
        return prescriptionRepository.findById(id)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#prescription.getId()")
    @Override
    public void save(Prescription prescription) {
        PrescriptionJpaEntity prescriptionJpa = converter.toJpa(prescription);
        prescriptionRepository.save(prescriptionJpa);
    }
}
