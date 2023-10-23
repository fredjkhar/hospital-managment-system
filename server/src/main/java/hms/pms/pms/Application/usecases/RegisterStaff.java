package hms.pms.pms.Application.usecases;

import hms.pms.pms.Application.dtos.queries.StaffInfoCreateDTO;

import java.util.UUID;

public interface RegisterStaff {
    UUID registerStaff(StaffInfoCreateDTO staffInfo);
}
