package hms.pms.adapters.factories;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.application.dtos.queries.converters.StaffInfoDTOConverter;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.factories.StaffFactory;
import org.mapstruct.factory.Mappers;

public class StaffInfoDTOFactory implements StaffFactory {

    private final StaffInfoDTOConverter dtoConverter = Mappers.getMapper(StaffInfoDTOConverter.class);

    @Override
    public Staff createStaffAccount(StaffInfoCreateDTO staffInfoDTO) {
        return dtoConverter.convertDto(staffInfoDTO);
    }
}
