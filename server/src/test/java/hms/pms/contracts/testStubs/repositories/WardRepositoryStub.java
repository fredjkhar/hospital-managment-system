package hms.pms.contracts.testStubs.repositories;

import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.repositories.WardRepository;

import java.util.HashMap;
import java.util.UUID;

public class WardRepositoryStub implements WardRepository {
    private HashMap<UUID, Ward> wards = new HashMap<>();
    @Override
    public Ward find(UUID wardId) {
        return wards.get(wardId);
    }

    @Override
    public void save(Ward ward) {
        wards.put(ward.getWardId(), ward);
    }
}
