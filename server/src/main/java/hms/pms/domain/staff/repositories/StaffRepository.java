package hms.pms.domain.staff.repositories;

import java.util.UUID;

import hms.pms.domain.staff.entities.staff.Staff;

public interface StaffRepository {
    public Staff find(String EmployeeNbr);

    public void save(Staff staff);
    
}
