package hms.pms.contracts.testStubs.factories;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;
import hms.pms.domain.division.entities.Bed;
import hms.pms.domain.division.entities.Room;
import hms.pms.domain.division.entities.Ward;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.patient.factories.AdmissionFormFactory;

public class PatientRegFormFactoryStub implements PatientRegFormFactory {

    @Override
    public PatientRegForm createPatientRegistrationForm(
        Staff medicalStaffMember, String patientName, String localDoctorId, String division) {
        PatientRegForm registrationForm = new PatientRegistrationForm();
        registrationForm.setMedicalStaffMember(medicalStaffMember);
        registrationForm.setPatientName(patientName);
        registrationForm.setLocalDoctorId(localDoctorId);
        registrationForm.setDivision(division);
        registrationForm.setPatientCondition("Stable");
        registrationForm.setAdmissionDate("2023-11-15");
        return registrationForm;
    }
}