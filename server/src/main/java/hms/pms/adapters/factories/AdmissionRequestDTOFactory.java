package hms.pms.adapters.factories;

import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.application.dtos.queries.converters.AdmissionRequestDTOConverter;
import hms.pms.domain.ward.entities.AdmissionRequest;
import hms.pms.domain.ward.factories.AdmissionRequestFactory;
import org.mapstruct.factory.Mappers;

public class AdmissionRequestDTOFactory implements AdmissionRequestFactory {

    private final AdmissionRequestDTOConverter dtoConverter = Mappers.getMapper(AdmissionRequestDTOConverter.class);

    @Override
    public AdmissionRequest createAdmissionRequest(AdmissionRequestCreateDTO patientAdmissionRequestInfo) {
        return dtoConverter.convertDto(patientAdmissionRequestInfo);
    }
}
