package hms.pms.domain.ward.repositories;

import hms.pms.domain.ward.entities.Ward;
import java.util.UUID;

public interface WardRepository {
    Ward find(UUID wardId);
    void save(Ward ward);
}
