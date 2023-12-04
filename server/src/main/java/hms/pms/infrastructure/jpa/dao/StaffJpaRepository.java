package hms.pms.infrastructure.jpa.dao;

import hms.pms.infrastructure.jpa.entities.staff.StaffJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffJpaRepository extends JpaRepository<StaffJpaEntity, UUID> {

}
