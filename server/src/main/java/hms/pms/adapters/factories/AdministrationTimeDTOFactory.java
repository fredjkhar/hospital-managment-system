package hms.pms.adapters.factories;

import hms.pms.application.dtos.queries.AdministrationTimeCreateDTO;
import hms.pms.application.dtos.queries.converters.AdministrationTimeDTOConverter;
import hms.pms.domain.prescription.Entities.AdministrationTime;
import hms.pms.domain.prescription.factory.AdministrationTimeFactory;
import org.mapstruct.factory.Mappers;

public class AdministrationTimeDTOFactory implements AdministrationTimeFactory {

    private final AdministrationTimeDTOConverter dtoConverter = Mappers.getMapper(AdministrationTimeDTOConverter.class);

    @Override
    public AdministrationTime createAdministrationTime(AdministrationTimeCreateDTO administrationTimeInfo) {
        return dtoConverter.convertDto(administrationTimeInfo);
    }
}
