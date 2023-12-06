package hms.pms.infrastructure.jpa.dao;

import hms.pms.infrastructure.jpa.entities.ward.AdmissionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdmissionJpaRepository extends JpaRepository<AdmissionJpaEntity, UUID> {
    Optional<AdmissionJpaEntity> findByPatientId(UUID patientId);
}
