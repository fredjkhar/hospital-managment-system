package hms.pms.adapters.factories;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.application.dtos.queries.converters.AdmissionDTOConverter;
import hms.pms.domain.ward.entities.Admission;
import hms.pms.domain.ward.entities.AdmissionRequest;
import hms.pms.domain.ward.factories.AdmissionFactory;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

public class AdmissionDTOFactory implements AdmissionFactory {
    private final AdmissionDTOConverter dtoConverter = Mappers.getMapper(AdmissionDTOConverter.class);
    @Override
    public Admission createAdmission(AdmissionCreateDTO admissionInfo) {
        return dtoConverter.convertDto(admissionInfo);
    }

    @Override
    public Admission createAdmission(AdmissionRequest admissionRequest, UUID roomNbr, UUID bedNbr, String insuranceNumber) {
        return null; //TODO: implement this
    }
}
