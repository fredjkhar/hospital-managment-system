package hms.pms.contracts.testStubs.factories;

import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.domain.ward.entities.AdmissionRequest;
import hms.pms.domain.ward.factories.AdmissionRequestFactory;

public class AdmissionRequestFactoryStub implements AdmissionRequestFactory {
    @Override
    public AdmissionRequest createAdmissionRequest(AdmissionRequestCreateDTO patientAdmissionRequestInfo) {
        return null;
    }
}
