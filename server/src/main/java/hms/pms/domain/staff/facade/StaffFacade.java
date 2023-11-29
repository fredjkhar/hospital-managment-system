package hms.pms.domain.staff.facade;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.domain.staff.entities.staff.Staff;

import java.util.UUID;

public interface StaffFacade {
    UUID createStaffAccount(StaffInfoCreateDTO staffInfo);
    boolean updateStaffAccount(String staffId, StaffInfoCreateDTO staffInfo);
}
