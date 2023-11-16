package hms.pms.domain.prescription.facade.implementation;

import hms.pms.Application.dtos.queries.PrescriptionCreateDTO;
import hms.pms.domain.prescription.*;
import hms.pms.domain.prescription.facade.*;
import hms.pms.domain.prescription.factory.*;
import hms.pms.domain.prescription.repository.*;




public class prescriptionFacadeImpl implements prescriptionFacade {
    private final prescriptionRepository prescriptionRepository;
    private final prescriptionFactory prescriptionFactory;

    public prescriptionFacadeImpl(prescriptionRepository prescriptionRepository, prescriptionFactory prescriptionFactory) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionFactory = prescriptionFactory;
    }

    public UUID createPrescription(PrescriptionCreateDTO prescriptionDto) {

        // Create a new prescription using the factory
        prescription newPrescription = prescriptionFacade.createPrescription(prescriptionDto);

        // Save the new prescription
        prescriptionRepository.save(newPrescription);

        return newPrescription.getId();
    }

}


