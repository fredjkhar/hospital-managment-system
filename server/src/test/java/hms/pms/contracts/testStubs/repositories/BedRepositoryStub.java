package hms.pms.contracts.testStubs.repositories;

import hms.pms.domain.ward.entities.Bed;
import hms.pms.domain.ward.repositories.BedRepository;

import java.util.HashMap;
import java.util.UUID;

public class BedRepositoryStub implements BedRepository {
    private HashMap<UUID, Bed> beds = new HashMap<>();

    @Override
    public Bed find(UUID bedNbr) {
        return beds.get(bedNbr);
    }

    @Override
    public void save(Bed bed) {
        beds.put(bed.getBedNbr(), bed);
    }
}
