package hms.pms.adapters.repositories.converters;

import hms.pms.domain.patient.entities.Address;
import hms.pms.domain.patient.entities.NextOfKin;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.infrastructure.jpa.entities.patient.AddressJpaEntity;
import hms.pms.infrastructure.jpa.entities.patient.NextOfKinJpaEntity;
import hms.pms.infrastructure.jpa.entities.patient.PatientJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientJpaConverter {
    PatientJpaEntity toJpa(Patient patient);

    Patient toModel(PatientJpaEntity patientJpaEntity);

    AddressJpaEntity addressToJpa(Address address);

    Address addressToModel(AddressJpaEntity addressJpaEntity);

    NextOfKinJpaEntity nextOfKinToJpa(NextOfKin nextOfKin);

    NextOfKin nextOfKinToModel(NextOfKinJpaEntity nextOfKinJpaEntity);
}
