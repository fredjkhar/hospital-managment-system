package hms.pms.infrastructure.jpa.dao;

import hms.pms.infrastructure.jpa.entities.prescription.AdministrationTimeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdministrationTimeJpaRepository extends JpaRepository<AdministrationTimeJpaEntity, UUID> {
}
