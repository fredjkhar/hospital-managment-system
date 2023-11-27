package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;

public interface RegisterStaff {
    void registerStaff(StaffInfoCreateDTO staffInfo);
}
