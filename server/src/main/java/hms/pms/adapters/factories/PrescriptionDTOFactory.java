package hms.pms.adapters.factories;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.application.dtos.queries.converters.PrescriptionDTOConverter;
import hms.pms.domain.prescription.Entities.Prescription;
import hms.pms.domain.prescription.factory.PrescriptionFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Primary
@Component
public class PrescriptionDTOFactory implements PrescriptionFactory {
    private final PrescriptionDTOConverter dtoConverter = Mappers.getMapper(PrescriptionDTOConverter.class);
    @Override
    public Prescription createPrescription(PrescriptionCreateDTO prescriptionCreateDto) {
        Prescription prescription = dtoConverter.covertDto(prescriptionCreateDto);
        return prescription;
    }
}
