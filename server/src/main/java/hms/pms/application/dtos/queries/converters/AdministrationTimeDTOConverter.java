package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.AdministrationTimeCreateDTO;
import hms.pms.domain.prescription.Entities.AdministrationTime;
import org.mapstruct.Mapper;

@Mapper
public interface AdministrationTimeDTOConverter {
    AdministrationTime convertDto(AdministrationTimeCreateDTO administrationTimeInfo);
}
