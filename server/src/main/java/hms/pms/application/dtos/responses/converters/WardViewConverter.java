package hms.pms.application.dtos.responses.converters;

import hms.pms.application.dtos.responses.WardViewDTO;
import hms.pms.domain.ward.entities.Ward;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface WardViewConverter {
    @Mappings({

    })
    WardViewDTO toView(Ward ward);
}
