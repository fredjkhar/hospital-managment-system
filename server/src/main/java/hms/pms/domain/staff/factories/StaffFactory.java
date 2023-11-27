package hms.pms.domain.staff.factories;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.domain.staff.entities.Staff;

public interface StaffFactory {
    Staff createStaffAccount(StaffInfoCreateDTO staffInfoDTO);
}
