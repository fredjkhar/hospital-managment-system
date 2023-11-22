package hms.pms.domain.staff.repositories;

import hms.pms.domain.staff.entities.Staff;

import java.util.UUID;

public interface StaffRepository {
    Staff find(UUID EmployeeNbr);

    void save(Staff staff);
    
}
