package hms.pms.application.usecases;

import hms.pms.application.dtos.responses.WardViewDTO;

import java.util.UUID;

public interface VisualizeWard {
    WardViewDTO getWardView(UUID wardId);
}
