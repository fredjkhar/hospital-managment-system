package hms.pms.domain.patient.facade.implementation;

import hms.pms.Application.dtos.queries.AddressCreateDTO;
import hms.pms.Application.dtos.queries.NextOfKinCreateDTO;
import hms.pms.Application.dtos.queries.PatientCreateDTO;
import hms.pms.Application.services.DomainEventEmitter;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.events.PatientCreated;
import hms.pms.domain.patient.events.PatientUpdated;
import hms.pms.domain.patient.facade.PatientFacade;
import hms.pms.domain.patient.factories.PatientFactory;
import hms.pms.domain.patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class PatientFacadeImpl implements PatientFacade {

    private final PatientRepository patientRepository;
    private final PatientFactory patientFactory;
    private final DomainEventEmitter eventEmitter;

    @Autowired
    public PatientFacadeImpl(PatientRepository patientRepository,
                             PatientFactory patientFactory,
                             DomainEventEmitter eventEmitter) {
        this.patientRepository = patientRepository;
        this.patientFactory = patientFactory;
        this.eventEmitter = eventEmitter;
    }

    @Override
    public boolean createPatient(PatientCreateDTO patientInfo) {
        if (patientRepository.find(patientInfo.getInsuranceNumber()) != null) return false;

        Patient patient = patientFactory.createPatient(patientInfo);
        patientRepository.save(patient);

        AddressCreateDTO addressInfo = patientInfo.getAddressInfo();
        patient.setAddress(addressInfo);

        NextOfKinCreateDTO nextOfKinInfo = patientInfo.getNextOfKinInfo();
        patient.setNextOfKin(nextOfKinInfo);

        patientRepository.save(patient);
        eventEmitter.emit(new PatientCreated(UUID.randomUUID(), new Date(), patient.getPatientId()));
        return true;
    }

    @Override
    public boolean updatePatient(UUID patientID, PatientCreateDTO patientInfo) {
        Patient patient = patientRepository.find(patientID);
        if (patient == null) return false;

        Patient updated = patientFactory.createPatient(patientInfo);

        AddressCreateDTO addressInfo = patientInfo.getAddressInfo();
        patient.setAddress(addressInfo);

        NextOfKinCreateDTO nextOfKinInfo = patientInfo.getNextOfKinInfo();
        patient.setNextOfKin(nextOfKinInfo);

        patient.update(updated);
        patientRepository.save(patient);

        eventEmitter.emit(new PatientUpdated(UUID.randomUUID(), new Date(), patient.getPatientId()));
        return true;
    }
}
