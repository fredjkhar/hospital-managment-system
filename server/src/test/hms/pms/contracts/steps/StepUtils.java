package hms.pms.contracts.testStubs.contracts.steps;

import hms.pms.application.dtos.queries.AccountCreateDto;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.Staff.entities.Staff;
import hms.pms.contracts.testStubs.repositories.PatientRepositoryStub;
import hms.pms.contracts.testStubs.repositories.StaffRepositoryStub;

import java.time.LocalDate;

public class PatientRegistrationTestUtils {

    public static Staff createStaffAccount(StaffRepositoryStub repository) {
        Staff staffMember = new Staff("124231", "qefsdas", "fname", "lname", "dr", "wqd@csed.com");
        repository.save(staffMember);
        return staffMember;
    }

    public static Patient createPatientAccount(PatientRepositoryStub repository) {
        Patient patient = new Patient("123", "fname", "lname", "vanier", "0123456789", "12-12-12","F", "single", "756453235");
        repository.save(patient);
        return patient;
    }

}
