package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;

public interface RegisterStaff {
    void registerStaff(StaffInfoCreateDTO staffInfo);
}
