package hms.pms.contracts.testStubs.factories;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.domain.ward.entities.Admission;
import hms.pms.domain.ward.factories.AdmissionFactory;

public class AdmissionFactoryStub implements AdmissionFactory {
    @Override
    public Admission createAdmission(AdmissionCreateDTO admissionInfo) {
        return new Admission(admissionInfo.getPatientId(), admissionInfo.getLocalDoctorId(),
                admissionInfo.getRoomNumber(), admissionInfo.getBedNumber(), admissionInfo.getPrivateInsuranceNumber(),
                admissionInfo.getRationaleForRequest(), admissionInfo.getPriorityAssessment());
    }
}
