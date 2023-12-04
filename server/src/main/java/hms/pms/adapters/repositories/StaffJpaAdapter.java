package hms.pms.adapters.repositories;

import hms.pms.adapters.repositories.converters.StaffJpaConverter;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.repositories.StaffRepository;
import hms.pms.infrastructure.jpa.dao.StaffJpaRepository;
import hms.pms.infrastructure.jpa.entities.staff.StaffJpaEntity;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@CacheConfig(cacheNames = {"staff"})
public class StaffJpaAdapter implements StaffRepository {
    private final StaffJpaRepository staffRepository;
    private final StaffJpaConverter converter = Mappers.getMapper(StaffJpaConverter.class);

    @Autowired
    public StaffJpaAdapter(StaffJpaRepository staffJpaRepository) {
        this.staffRepository = staffJpaRepository;
    }

    @Cacheable(key = "#EmployeeNbr")
    @Transactional
    @Override
    public Staff find(UUID EmployeeNbr) {
        return staffRepository.findById(EmployeeNbr)
                .map(converter::toModel)
                .orElse(null);
    }

    @CachePut(key = "#staff.getId()")
    @Override
    public void save(Staff staff) {
        StaffJpaEntity staffJpa = converter.toJpa(staff);
        staffRepository.save(staffJpa);
    }
}
