package hms.pms.contracts.testStubs.factories;


public class PatientRegFormFactoryStub implements PatientRegFormFactory {

    @Override
    public PatientRegForm createPatientRegistrationForm(
        Staff medicalStaffMember, String patientName, String localDoctorId, String ward) {
        PatientRegForm registrationForm = new PatientRegistrationForm();
        registrationForm.setMedicalStaffMember(medicalStaffMember);
        registrationForm.setPatientName(patientName);
        registrationForm.setLocalDoctorId(localDoctorId);
        registrationForm.setWard(ward);
        registrationForm.setPatientCondition("Stable");
        registrationForm.setAdmissionDate("2023-11-15");
        return registrationForm;
    }
}
