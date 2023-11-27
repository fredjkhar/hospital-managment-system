package hms.pms.Infrastructure.jpa.dao;

import hms.pms.domain.ward.entities.Bed;
import hms.pms.domain.ward.repositories.BedRepository;

import java.util.UUID;

public class BedJpaRepository implements BedRepository {
    @Override
    public Bed find(UUID bedNbr) {
        return null;
    }

    @Override
    public void save(Bed bed) {

    }
}
