package hms.pms.domain.prescription.facade.implementation;

import hms.pms.Application.dtos.queries.AdministrationTimesCreateDTO;
import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.Application.services.DomainEventEmitter;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.prescription.Entities.Prescription;
import hms.pms.domain.prescription.events.PrescriptionCreated;
import hms.pms.domain.prescription.events.PrescriptionUpdated;
import hms.pms.domain.prescription.facade.*;
import hms.pms.domain.prescription.factory.PrescriptionFactory;
import hms.pms.domain.prescription.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class PrescriptionFacadeImpl implements PrescriptionFacade {

    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionFactory prescriptionFactory;
    private final PatientRepository patientRepository;
    private final DomainEventEmitter eventEmitter;

    @Autowired
    public PrescriptionFacadeImpl(PrescriptionRepository prescriptionRepository,
                                  PrescriptionFactory prescriptionFactory,
                                  PatientRepository patientRepository,
                                  DomainEventEmitter eventEmitter) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionFactory = prescriptionFactory;
        this.patientRepository = patientRepository;
        this.eventEmitter = eventEmitter;
    }

    @Override
    public boolean createPrescription(UUID patientId, PrescriptionCreateDTO prescriptionInfo) {
        Patient patient = patientRepository.find(patientId);
        if (patient == null) return false;

        Prescription prescription = prescriptionFactory.createPrescription(prescriptionInfo);

        List<AdministrationTimesCreateDTO> administrationTimesInfo = prescriptionInfo.getAdministrationTimes();
        prescription.setAdministrationTimes(administrationTimesInfo);

        patient.addPrescription(prescription.getPrescriptionId());
        prescriptionRepository.save(prescription);

        eventEmitter.emit(new PrescriptionCreated(UUID.randomUUID(), new Date(), patient.getPatientId(), prescription.getPrescriptionId()));
        return true;
    }

    @Override
    public boolean updatePrescription(UUID prescriptionId, UUID patientId, PrescriptionCreateDTO prescriptionInfo) {
        Patient patient = patientRepository.find(patientId);
        Prescription prescription = prescriptionRepository.find(prescriptionId);
        if (patient == null || prescription == null) return false;

        Prescription updated = prescriptionFactory.createPrescription(prescriptionInfo);

        List<AdministrationTimesCreateDTO> administrationTimesInfo = prescriptionInfo.getAdministrationTimes();
        prescription.setAdministrationTimes(administrationTimesInfo);

        prescription.update(updated);
        prescriptionRepository.save(prescription);

        eventEmitter.emit(new PrescriptionUpdated(UUID.randomUUID(), new Date(), patient.getPatientId(), prescription.getPrescriptionId()));
        return true;
    }
}


