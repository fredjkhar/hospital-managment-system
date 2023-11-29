package hms.pms.domain.staff.factories;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.domain.staff.entities.staff.Staff;

public interface StaffFactory {
    Staff createStaffAccount(StaffInfoCreateDTO staffInfoDTO);
}
