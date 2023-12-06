package hms.pms.adapters.factories;

import hms.pms.application.dtos.queries.DischargeCreateDTO;
import hms.pms.application.dtos.queries.converters.DischargeDTOConverter;
import hms.pms.domain.ward.entities.Discharge;
import hms.pms.domain.ward.factories.DischargeFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class DischargeDTOFactory implements DischargeFactory {

    private final DischargeDTOConverter dtoConverter = Mappers.getMapper(DischargeDTOConverter.class);

    @Override
    public Discharge createDischarge(DischargeCreateDTO dischargeInfo) {
        return dtoConverter.convertDto(dischargeInfo);
    }
}
