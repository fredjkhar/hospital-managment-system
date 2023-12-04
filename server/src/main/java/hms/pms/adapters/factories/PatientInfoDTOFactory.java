package hms.pms.adapters.factories;

import hms.pms.application.dtos.queries.PatientInfoCreateDTO;
import hms.pms.application.dtos.queries.converters.PatientInfoDTOConverter;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.factories.PatientFactory;
import org.mapstruct.factory.Mappers;

public class PatientInfoDTOFactory implements PatientFactory {

    private final PatientInfoDTOConverter dtoConverter = Mappers.getMapper(PatientInfoDTOConverter.class);

    @Override
    public Patient createPatient(PatientInfoCreateDTO patientInfo) {
        return dtoConverter.convertDto(patientInfo);
    }
}
