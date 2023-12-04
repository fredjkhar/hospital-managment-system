package hms.pms.infrastructure.jpa.dao;

import hms.pms.infrastructure.jpa.entities.ward.WardJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WardJpaRepository extends JpaRepository<WardJpaEntity, UUID> {
}
