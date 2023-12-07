package hms.pms.application.dtos.queries.converters;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;
import hms.pms.domain.patient.entities.Patient;
import org.mapstruct.Mapper;

@Mapper
public interface PatientInfoDTOConverter {
    Patient convertDto(PatientInfoCreateDTO patientInfo);
}
