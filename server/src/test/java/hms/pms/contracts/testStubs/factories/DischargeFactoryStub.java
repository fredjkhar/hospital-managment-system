package hms.pms.contracts.testStubs.factories;

import hms.pms.domain.ward.entities.Discharge;
import hms.pms.domain.ward.factories.DischargeFactory;

import java.util.UUID;

public class DischargeFactoryStub implements DischargeFactory {
    @Override
    public Discharge createDischarge(UUID patientId, String dischargeSummary) {
        return null;
    }
}
