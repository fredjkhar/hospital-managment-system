package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.domain.staff.entities.Staff;
import org.mapstruct.Mapper;

@Mapper
public interface StaffInfoDTOConverter {
    Staff convertDto(StaffInfoCreateDTO staffInfo);
}
