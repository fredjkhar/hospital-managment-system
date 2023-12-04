package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.AdministrationTimeCreateDTO;
import hms.pms.domain.prescription.Entities.AdministrationTime;

public interface AdministrationTimeDTOConverter {
    AdministrationTime convertDto(AdministrationTimeCreateDTO administrationTimeInfo);
}
