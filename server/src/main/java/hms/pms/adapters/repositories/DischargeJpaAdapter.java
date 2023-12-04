package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.DischargeJpaConverter;
import hms.pms.domain.ward.entities.Discharge;
import hms.pms.domain.ward.repositories.DischargeRepository;
import hms.pms.infrastructure.jpa.dao.DischargeJpaRepository;
import hms.pms.infrastructure.jpa.entities.ward.DischargeJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"discharges"})
public class DischargeJpaAdapter implements DischargeRepository {
    private final DischargeJpaRepository dischargeRepository;
    private final DischargeJpaConverter converter = Mappers.getMapper(DischargeJpaConverter.class);

    @Autowired
    public DischargeJpaAdapter(DischargeJpaRepository dischargeJpaRepository) {
        this.dischargeRepository = dischargeJpaRepository;
    }

    @Cacheable(key = "#dischargeId")
    @Transactional
    @Override
    public Discharge find(UUID dischargeId) {
        return dischargeRepository.findById(dischargeId)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#discharge.getId()")
    @Override
    public void save(Discharge discharge) {
        DischargeJpaEntity dischargeJpa = converter.toJpa(discharge);
        dischargeRepository.save(dischargeJpa);
    }
}
