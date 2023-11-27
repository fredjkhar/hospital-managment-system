package hms.pms.Infrastructure.jpa.dao;

import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.repositories.StaffRepository;

import java.util.UUID;

public class StaffJpaRepository implements StaffRepository {
    @Override
    public Staff find(UUID EmployeeNbr) {
        return null;
    }

    @Override
    public void save(Staff staff) {

    }
}
