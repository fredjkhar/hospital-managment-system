package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.WardJpaConverter;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.repositories.WardRepository;
import hms.pms.infrastructure.jpa.dao.WardJpaRepository;
import hms.pms.infrastructure.jpa.entities.ward.WardJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"wards"})
public class WardJpaAdapter implements WardRepository {
    private final WardJpaRepository wardRepository;
    private final WardJpaConverter converter = Mappers.getMapper(WardJpaConverter.class);

    @Autowired
    public WardJpaAdapter(WardJpaRepository wardJpaRepository) {
        this.wardRepository = wardJpaRepository;
    }

    @Cacheable(key = "#wardId")
    @Transactional
    @Override
    public Ward find(UUID wardId) {
        return wardRepository.findById(wardId)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#ward.getId()")
    @Override
    public void save(Ward ward) {
        WardJpaEntity wardJpa = converter.toJpa(ward);
        wardRepository.save(wardJpa);
    }
}
