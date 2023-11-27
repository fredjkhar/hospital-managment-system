package hms.pms.domain.staff.facade;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;

public interface StaffFacade {
    void createStaffAccount(StaffInfoCreateDTO staffInfo);
}
