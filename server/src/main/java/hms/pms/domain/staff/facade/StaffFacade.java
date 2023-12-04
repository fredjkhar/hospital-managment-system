package hms.pms.domain.staff.facade;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;

import java.util.UUID;

public interface StaffFacade {
    void createStaffAccount(StaffInfoCreateDTO staffInfo);

    void updateStaffAccount(UUID patientId, StaffInfoCreateDTO staffInfo);
}
