package hms.pms.domain.staff.facade;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;

public interface StaffFacade {
    void createStaffAccount(StaffInfoCreateDTO staffInfo);
}
