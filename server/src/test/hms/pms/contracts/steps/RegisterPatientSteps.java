import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RegisterPatientSteps {

    private MedicalStaff medicalStaff;
    private Patient patient;
    private ChargeNurse chargeNurse;
    private PatientRegistrationForm patientForm;
    private PatientRepository patientRepository;

    @Given("a medical staff member is logged in")
    public void medicalStaffMemberIsLoggedIn() {
        medicalStaff = MedicalStaff.login();
    }

    @Given("the medical staff member provides valid and complete patient information")
    public void medicalStaffMemberProvidesValidPatientInformation() {
        patientForm = PatientRegistrationForm.createValidForm();
    }

    @Given("the Local Doctor ID matches a doctor in the HMS")
    public void localDoctorIdMatchesDoctorInHMS() {
        Assert.assertTrue(DoctorService.isMatchingDoctor(patientForm.getLocalDoctorID()));
    }

    @When("the staff member submits the patient registration form")
    public void staffMemberSubmitsRegistrationForm() {
        patient = medicalStaff.registerPatient(patientForm);
    }

    @Then("the system registers the patient with the provided information")
    public void systemRegistersPatient() {
        Assert.assertTrue(patientRepository.isPatientRegistered(patient));
    }

    @Then("assigns a primary Charge Nurse to the patient based on the division")
    public void assignsPrimaryChargeNurse() {
        chargeNurse = ChargeNurseService.assignPrimaryChargeNurse(patient.getDivision());
        Assert.assertNotNull(chargeNurse);
    }

    @Then("sends a confirmation message to the medical staff member")
    public void sendsConfirmationMessage() {
        Assert.assertTrue(NotificationService.sendConfirmationMessage(medicalStaff));
    }

    @Given("the provided patient details match an existing patient in the HMS")
    public void providedPatientDetailsMatchExistingPatient() {
        Patient existingPatient = Patient.create(patientForm);
        patientRepository.registerPatient(existingPatient);
    }

    @Then("the system displays a message indicating the patient already exists")
    public void systemDisplaysPatientExistsMessage() {
        Assert.assertTrue(NotificationService.displayPatientExistsMessage());
    }

    @Given("the provided patient information is incomplete or invalid")
    public void providedPatientInformationIsInvalid() {
        patientForm = PatientRegistrationForm.createInvalidForm();
    }

    @Then("the system displays an error message indicating missing or invalid data")
    public void systemDisplaysErrorMessage() {
        Assert.assertTrue(NotificationService.displayErrorMessage());
    }
}
