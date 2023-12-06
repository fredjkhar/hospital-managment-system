package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.responses.PatientFileViewDTO;
import hms.pms.application.dtos.responses.converters.PatientFileViewConverter;
import hms.pms.application.usecases.ConsultPatientFile;
import hms.pms.domain.patient.entities.Address;
import hms.pms.domain.patient.entities.NextOfKin;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.prescription.Entities.Prescription;
import hms.pms.domain.prescription.repository.PrescriptionRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConsultPatientFileImpl implements ConsultPatientFile {
    private final PatientFileViewConverter converter = Mappers.getMapper(PatientFileViewConverter.class);
    private final PatientRepository patientRepository;

    @Autowired
    public ConsultPatientFileImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientFileViewDTO getPatientFile(UUID patientId) {
        if (patientId == null) return null;
        Patient patient = patientRepository.find(patientId);
        if (patient == null) {
            return null;
        }

        Address address = patient.getAddress();
        NextOfKin nextOfKin = patient.getNextOfKin();

        List<UUID> prescriptionIds = patient.getPrescriptions();


        return converter.toView(patient, address, nextOfKin, prescriptionIds);
    }
}
