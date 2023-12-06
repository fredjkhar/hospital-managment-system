package hms.pms.application.dtos.responses.converters;

import hms.pms.application.dtos.responses.PatientFileViewDTO;
import hms.pms.domain.patient.entities.Address;
import hms.pms.domain.patient.entities.NextOfKin;
import hms.pms.domain.patient.entities.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.UUID;

@Mapper
public interface PatientFileViewConverter {
    @Mappings({
            @Mapping(source = "patient.patientId", target = "patientId"),
            @Mapping(source = "patient.insuranceNumber", target = "insuranceNumber"),
            @Mapping(source = "patient.firstName", target = "firstName"),
            @Mapping(source = "patient.lastName", target = "lastName"),
            @Mapping(source = "patient.phoneNumber", target = "phoneNumber"),
            @Mapping(source = "patient.dateOfBirth", target = "dateOfBirth", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "patient.gender", target = "gender"),
            @Mapping(source = "patient.maritalStatus", target = "maritalStatus"),
            @Mapping(source = "patient.externalDoctorId", target = "externalDoctorId"),
            @Mapping(source = "patient.primaryChargeNurseId", target = "primaryChargeNurseId"),
            @Mapping(source = "address.street", target = "street"),
            @Mapping(source = "address.city", target = "city"),
            @Mapping(source = "address.postalCode", target = "postalCode"),
            @Mapping(source = "address.country", target = "country"),
            @Mapping(source = "nextOfKin.firstName", target = "nokFirstName"),
            @Mapping(source = "nextOfKin.lastName", target = "nokLastName"),
            @Mapping(source = "nextOfKin.phoneNumber", target = "nokPhoneNumber"),
            @Mapping(source = "nextOfKin.relationshipToPatient", target = "nokRelationship"),
            @Mapping(source = "prescriptions", target = "prescriptions")
    })
    PatientFileViewDTO toView(Patient patient, Address address, NextOfKin nextOfKin, List<UUID> prescriptions);
}
