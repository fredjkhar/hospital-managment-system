package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.responses.WardViewDTO;
import hms.pms.application.dtos.responses.converters.WardViewConverter;
import hms.pms.application.usecases.VisualizeWard;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.repositories.WardRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class VisualizeWardImpl implements VisualizeWard {
    private final WardViewConverter converter = Mappers.getMapper(WardViewConverter.class);
    private final WardRepository wardRepository;

    @Autowired
    public VisualizeWardImpl(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    @Override
    public WardViewDTO getWardView(UUID wardId) {
        if (wardId != null) {
            Ward ward = wardRepository.find(wardId);

            if (ward != null) {
                return converter.toView(ward);
            }
        }
        return null;
    }
}
