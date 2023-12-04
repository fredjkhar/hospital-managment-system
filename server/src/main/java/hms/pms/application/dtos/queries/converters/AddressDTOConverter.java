package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.AddressCreateDTO;
import hms.pms.domain.patient.entities.Address;

public interface AddressDTOConverter {
    Address covertDto(AddressCreateDTO addressInfo);
}
