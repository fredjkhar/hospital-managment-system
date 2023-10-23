package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;

import java.util.UUID;

public interface RegisterStaff {
    UUID registerStaff(StaffInfoCreateDTO staffInfo);
}
