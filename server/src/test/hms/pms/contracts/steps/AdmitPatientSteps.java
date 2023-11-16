import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AdmitPatientSteps {

    private ChargeNurse chargeNurse;
    private Patient patient;
    private Ward ward;
    private Room room;
    private Bed bed;
    private AdmissionForm admissionForm;

    @Given("the charge nurse is logged in")
    public void chargeNurseIsLoggedIn() {
        chargeNurse = ChargeNurse.login();
    }

    @Given("is consulting a patient’s file")
    public void consultingPatientFile() {
        patient = Patient.getConsultedPatient(chargeNurse);
    }

    @Given("there is an available bed in the specified ward")
    public void availableBedInWard() {
        ward = WardService.findAvailableWard();
        Assert.assertNotNull(ward);
        bed = BedService.findAvailableBed(ward);
        Assert.assertNotNull(bed);
    }

    @Given("the charge nurse selects the available room and bed")
    public void chargeNurseSelectsRoomAndBed() {
        room = RoomService.selectAvailableRoom(ward);
        Assert.assertNotNull(room);
    }

    @Given("enters all remaining admission information")
    public void entersAdmissionInformation() {
        admissionForm = AdmissionForm.createValidAdmissionForm(patient, ward, room, bed);
    }

    @When("the charge nurse submits the admission form")
    public void chargeNurseSubmitsAdmissionForm() {
        AdmissionService.admitPatient(admissionForm);
    }

    @Then("the system admits the patient to the selected bed in the ward")
    public void systemAdmitsPatientToBed() {
        Assert.assertTrue(PatientService.isAdmittedToBed(patient, bed));
    }

    @Then("updates bed availability and patient information")
    public void updatesBedAvailabilityAndPatientInfo() {
        Assert.assertFalse(BedService.isBedAvailable(bed));
        Assert.assertTrue(WardService.isWardOccupied(ward));
    }

    @Then("displays a confirmation of successful admission")
    public void displaysAdmissionConfirmation() {
        Assert.assertTrue(NotificationService.displayAdmissionConfirmation());
    }

    @Given("the specified ward is full")
    public void specifiedWardIsFull() {
        ward = WardService.findFullWard();
        Assert.assertNotNull(ward);
    }

    @When("the charge nurse attempts to admit a patient to the specified ward")
    public void chargeNurseAttemptsAdmissionToFullWard() {
        admissionForm = AdmissionForm.createValidAdmissionForm(patient, ward, room, bed);
    }

    @Then("the system notifies the charge nurse of the full status")
    public void systemNotifiesFullStatus() {
        Assert.assertTrue(NotificationService.notifyWardFull());
    }

    @Then("suggests initiating a patient admission request")
    public void suggestsAdmissionRequest() {
        Assert.assertTrue(NotificationService.suggestAdmissionRequest());
    }

    @Given("the provided ward room or bed details are invalid")
    public void invalidWardRoomBedDetails() {
        room = RoomService.selectInvalidRoom();
        bed = BedService.selectInvalidBed();
    }

    @Then("the system displays an error message indicating invalid room/bed details")
    public void systemDisplaysInvalidDetailsErrorMessage() {
        Assert.assertTrue(NotificationService.displayInvalidDetailsError());
    }

    @Then("requests valid room and bed details again")
    public void requestsValidDetailsAgain() {
        Assert.assertTrue(NotificationService.requestValidDetails());
    }
}
