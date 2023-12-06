package hms.pms.application.dtos.responses.converters;

import hms.pms.application.dtos.responses.WardViewDTO;
import hms.pms.domain.ward.entities.Ward;

public interface WardViewConverter {
    WardViewDTO toView(Ward ward);
}
