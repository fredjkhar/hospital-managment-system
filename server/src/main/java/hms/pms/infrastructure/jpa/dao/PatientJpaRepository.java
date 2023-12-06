package hms.pms.infrastructure.jpa.dao;

import hms.pms.infrastructure.jpa.entities.patient.PatientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientJpaRepository extends JpaRepository<PatientJpaEntity, UUID> {
  Optional<PatientJpaEntity> findByInsuranceNumber(String insuranceNumber);
}
