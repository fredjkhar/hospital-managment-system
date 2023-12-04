package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.AdmissionRequestJpaConverter;
import hms.pms.domain.ward.entities.AdmissionRequest;
import hms.pms.domain.ward.repositories.AdmissionRequestRepository;
import hms.pms.infrastructure.jpa.dao.AdmissionRequestJpaRepository;
import hms.pms.infrastructure.jpa.entities.ward.AdmissionRequestJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"admissionRequests"})
public class AdmissionRequestJpaAdapter implements AdmissionRequestRepository {
    private final AdmissionRequestJpaRepository admissionRequestRepository;
    private final AdmissionRequestJpaConverter converter = Mappers.getMapper(AdmissionRequestJpaConverter.class);

    @Autowired
    public AdmissionRequestJpaAdapter(AdmissionRequestJpaRepository admissionRequestRepository) {
        this.admissionRequestRepository = admissionRequestRepository;
    }

    @Cacheable(key = "#admissionRequestId")
    @Transactional
    @Override
    public AdmissionRequest find(UUID admissionRequestId) {
        return admissionRequestRepository.findById(admissionRequestId)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#admissionRequest.getId()")
    @Override
    public void save(AdmissionRequest admissionRequest) {
        AdmissionRequestJpaEntity admissionRequestJpa = converter.toJpa(admissionRequest);
        admissionRequestRepository.save(admissionRequestJpa);
    }
}
