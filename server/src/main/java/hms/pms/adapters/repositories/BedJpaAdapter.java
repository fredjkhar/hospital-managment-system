package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.BedJpaConverter;
import hms.pms.domain.ward.entities.Bed;
import hms.pms.domain.ward.repositories.BedRepository;
import hms.pms.infrastructure.jpa.dao.BedJpaRepository;
import hms.pms.infrastructure.jpa.entities.ward.BedJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"beds"})
public class BedJpaAdapter implements BedRepository {
    private final BedJpaRepository bedRepository;
    private final BedJpaConverter converter = Mappers.getMapper(BedJpaConverter.class);

    @Autowired
    public BedJpaAdapter(BedJpaRepository bedJpaRepository) {
        this.bedRepository = bedJpaRepository;
    }

    @Cacheable(key = "#bedNbr")
    @Transactional
    @Override
    public Bed find(UUID bedNbr) {
        return bedRepository.findById(bedNbr)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#bed.getId()")
    @Override
    public void save(Bed bed) {
        BedJpaEntity bedJpa = converter.toJpa(bed);
        bedRepository.save(bedJpa);
    }
}
