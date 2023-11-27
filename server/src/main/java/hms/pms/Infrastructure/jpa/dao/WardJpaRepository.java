package hms.pms.Infrastructure.jpa.dao;

import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.repositories.WardRepository;

import java.util.UUID;

public class WardJpaRepository implements WardRepository {
    @Override
    public Ward find(UUID wardId) {
        return null;
    }

    @Override
    public void save(Ward ward) {

    }
}
