package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.NextOfKinCreateDTO;
import hms.pms.domain.patient.entities.NextOfKin;

public interface NextOfKinDTOConverter {
    NextOfKin convertDto(NextOfKinCreateDTO nextOfKinInfo);
}
