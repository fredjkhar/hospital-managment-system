package hms.pms.domain.ward.repositories;

import hms.pms.domain.ward.entities.Bed;

import java.util.UUID;

public interface BedRepository {
    Bed find(UUID bedNbr);
    void save(Bed bed);
}
