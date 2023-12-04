package hms.pms.domain.prescription.factory;

import hms.pms.application.dtos.queries.AdministrationTimeCreateDTO;
import hms.pms.domain.prescription.Entities.AdministrationTime;

public interface AdministrationTimeFactory {
    AdministrationTime createAdministrationTime(AdministrationTimeCreateDTO administrationTimeInfo);
}
