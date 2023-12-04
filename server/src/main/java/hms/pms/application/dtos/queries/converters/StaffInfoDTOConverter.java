package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.domain.staff.entities.Staff;

public interface StaffInfoDTOConverter {
    Staff convertDto(StaffInfoCreateDTO staffInfo);
}
