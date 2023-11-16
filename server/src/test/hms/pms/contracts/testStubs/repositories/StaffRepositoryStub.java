package hms.pms.contracts.testStubs.repositories;

import hms.pms.Patient.entities.Staff;
import your.domain.medicalstaff.repositories.StaffRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StaffRepositoryStub implements StaffRepository {
    private final Map<String, Staff> staffMembers = new HashMap<>();

    @Override
    public Staff save(Staff staffMember) {
        staffMembers.put(staffMember.getId(), staffMember);
        return staffMember;
    }

    @Override
    public Optional<Staff> findById(String staffMemberId) {
        return Optional.ofNullable(staffMembers.get(staffMemberId));
    }
}
