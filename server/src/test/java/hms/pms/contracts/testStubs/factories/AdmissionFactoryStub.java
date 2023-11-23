package hms.pms.contracts.testStubs.factories;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateDTO;
import hms.pms.domain.ward.entities.Admission;
import hms.pms.domain.ward.factories.AdmissionFactory;

public class AdmissionFactoryStub implements AdmissionFactory {
    @Override
    public Admission createAdmission(PatientAdmissionCreateDTO admissionInfo) {
        return new Admission(admissionInfo.getPatientId(), admissionInfo.getLocalDoctorId(),
                admissionInfo.getRoomNumber(), admissionInfo.getBedNumber(), admissionInfo.getPrivateInsuranceNumber(),
                admissionInfo.getRationaleForRequest(), admissionInfo.getPriorityAssessment());
    }
}
