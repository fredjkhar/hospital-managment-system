package hms.pms.domain.staff.facade;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;

import java.util.UUID;

public interface StaffFacade {
    boolean createStaffAccount(StaffInfoCreateDTO staffInfo);
}
