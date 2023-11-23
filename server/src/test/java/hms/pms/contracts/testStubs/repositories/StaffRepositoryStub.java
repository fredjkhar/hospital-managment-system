package hms.pms.contracts.testStubs.repositories;

import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.repositories.StaffRepository;

import java.util.HashMap;
import java.util.UUID;

public class StaffRepositoryStub implements StaffRepository {
    private HashMap<UUID, Staff> staffUsers = new HashMap<>();

    @Override
    public Staff find(UUID EmployeeNbr) {
        return staffUsers.get(EmployeeNbr);
    }

    @Override
    public void save(Staff staff) {
        staffUsers.put(staff.getEmployeeNbr(), staff);
    }
}
