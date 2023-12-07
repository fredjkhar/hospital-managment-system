package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.DischargeCreateDTO;
import hms.pms.domain.ward.entities.Discharge;
import org.mapstruct.Mapper;

@Mapper
public interface DischargeDTOConverter {
    Discharge convertDto(DischargeCreateDTO dischargeInfo);
}
