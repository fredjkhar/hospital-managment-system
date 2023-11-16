package hms.pms.Application.ward.repositories;

import hms.pms.Application.ward.entities.Ward;
import java.util.UUID;

public interface WardRepository {
    
    public Ward find(UUID wardId);
    public void save(Ward ward);
}
