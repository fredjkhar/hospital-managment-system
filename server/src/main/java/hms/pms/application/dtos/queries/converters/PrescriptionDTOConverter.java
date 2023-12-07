package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.domain.prescription.Entities.Prescription;
import org.mapstruct.Mapper;

@Mapper
public interface PrescriptionDTOConverter {
    Prescription covertDto(PrescriptionCreateDTO prescriptionInfo);
}
