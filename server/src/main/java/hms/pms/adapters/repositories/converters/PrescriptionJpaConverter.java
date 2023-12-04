package hms.pms.adapters.repositories.converters;

import hms.pms.domain.prescription.Entities.AdministrationTime;
import hms.pms.domain.prescription.Entities.Prescription;
import hms.pms.infrastructure.jpa.entities.prescription.AdministrationTimeJpaEntity;
import hms.pms.infrastructure.jpa.entities.prescription.PrescriptionJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrescriptionJpaConverter {
    PrescriptionJpaEntity toJpa(Prescription prescription);

    Prescription toModel(PrescriptionJpaEntity prescriptionJpaEntity);

    AdministrationTimeJpaEntity administrationTimesToJpa(AdministrationTime administrationTime);

    AdministrationTime administrationTimesToModel(AdministrationTimeJpaEntity administrationTimeJpaEntity);
}
