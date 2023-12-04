package hms.pms.contracts.steps;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.contracts.testStubs.factories.AdmissionFactoryStub;
import hms.pms.contracts.testStubs.factories.AdmissionRequestFactoryStub;
import hms.pms.contracts.testStubs.factories.DischargeFactoryStub;
import hms.pms.contracts.testStubs.repositories.*;
import hms.pms.contracts.testStubs.services.DomainEventEmitterStub;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.entities.Room;
import hms.pms.domain.ward.entities.Bed;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.facade.implementation.WardFacadeImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Objects;
import java.util.UUID;

public class PatientStepDefinitions {
    private final StaffRepositoryStub staffRepositoryStub;
    private final PatientRepositoryStub patientRepositoryStub;
    private final RoomRepositoryStub roomRepositoryStub;
    private final BedRepositoryStub bedRepositoryStub;
    private final WardRepositoryStub wardRepositoryStub;

    private final AdmissionFactoryStub admissionFactoryStub;
    private final AdmissionRequestFactoryStub admissionRequestFactoryStub;
    private final DischargeFactoryStub dischargeFactoryStub;
    private final DomainEventEmitterStub eventEmitterStub;

    @Autowired
    public PatientStepDefinitions(StaffRepositoryStub staffRepositoryStub, PatientRepositoryStub patientRepositoryStub,
                                  RoomRepositoryStub roomRepositoryStub, BedRepositoryStub bedRepositoryStub,
                                  WardRepositoryStub wardRepositoryStub, AdmissionFactoryStub admissionFactoryStub,
                                  AdmissionRequestFactoryStub admissionRequestFactoryStub, DischargeFactoryStub dischargeFactoryStub,
                                  DomainEventEmitterStub eventEmitterStub) {
        this.staffRepositoryStub = staffRepositoryStub;
        this.patientRepositoryStub = patientRepositoryStub;
        this.roomRepositoryStub = roomRepositoryStub;
        this.bedRepositoryStub = bedRepositoryStub;
        this.wardRepositoryStub = wardRepositoryStub;
        this.admissionFactoryStub = admissionFactoryStub;
        this.admissionRequestFactoryStub = admissionRequestFactoryStub;
        this.dischargeFactoryStub = dischargeFactoryStub;
        this.eventEmitterStub = eventEmitterStub;
    }

    private Staff chargeNurse = null;
    private Patient patient = null;
    private Ward ward = null;
    private Room room = null;
    private Bed bed = null;
    private Bed invalidBed = null;
    private Ward wardFull = null;
    private AdmissionCreateDTO patientAdmissionInfo;
    private AdmissionCreateDTO patientAdmissionInfo_invalidBed;

    private WardFacade wardFacade;

    @Given("the charge nurse is logged in")
    public void the_charge_nurse_is_logged_in() {
        chargeNurse = StepUtils.createChargeNurseAccount(staffRepositoryStub);
        Assertions.assertNotNull(chargeNurse);
    }

    @Given("the charge nurse is consulting a patient’s file")
    public void the_charge_nurse_is_consulting_a_patients_file() {
        patient = StepUtils.createPatient(patientRepositoryStub);
        Assertions.assertNotNull(patient);
    }

    @Given("there is an available bed in the specified ward")
    public void there_is_an_available_bed_in_the_specified_ward() {
        ward = StepUtils.createWard(roomRepositoryStub, bedRepositoryStub, wardRepositoryStub);
        Assertions.assertNotNull(ward);
        Assertions.assertEquals("incomplete", ward.getStatus());
    }
    @Given("the specified ward is full")
    public void the_specified_ward_is_full() {
        wardFull = StepUtils.createFullWard(roomRepositoryStub, bedRepositoryStub, wardRepositoryStub);
        Assertions.assertNotNull(wardFull);
        Assertions.assertEquals("complete", wardFull.getStatus());
    }

    @Given("the charge nurse selects the available room and bed")
    public void the_charge_nurse_selects_the_available_room_and_bed() {
        UUID[] roomNbrs = ward.getRooms();
        for (UUID roomNbr: roomNbrs) {
            Room r = roomRepositoryStub.find(roomNbr);
            if (Objects.equals(r.getStatus(), "incomplete")) {
                room = r;
            }
        }
        Assertions.assertNotNull(room);
        Assertions.assertEquals("incomplete", room.getStatus());

        for (UUID bedNbr: room.getBeds()) {
            Bed b = bedRepositoryStub.find(bedNbr);
            if (Objects.equals(b.getStatus(), "incomplete")) {
                bed = b;
            }
        }
        Assertions.assertNotNull(bed);
        Assertions.assertEquals("incomplete", bed.getStatus());
    }

    @Given("the charge nurse enters all remaining admission information")
    public void the_charge_nurse_enters_all_remaining_admission_information() {
        UUID roomNbr = room == null  ? UUID.randomUUID() : room.getRoomNbr();
        UUID bedNbr = bed == null ? UUID.randomUUID() : bed.getBedNbr();
        patientAdmissionInfo = new AdmissionCreateDTO(patient.getPatientId(), UUID.randomUUID(),
                 roomNbr, bedNbr, "OHIP", "He's sick", 5);
        Assertions.assertNotNull(patientAdmissionInfo);
    }

    @Given("the charge nurse enters all remaining admission information with invalid bed or room details")
    public void the_charge_nurse_enters_all_remaining_admission_information_with_invalid_bed_or_room_details() {
        UUID[] roomNbrs = ward.getRooms();
        for (UUID roomNbr: roomNbrs) {
            Room r = roomRepositoryStub.find(roomNbr);
            if (Objects.equals(r.getStatus(), "incomplete")) {
                room = r;
            }
        }
        patientAdmissionInfo_invalidBed = new AdmissionCreateDTO(patient.getPatientId(), UUID.randomUUID(),
                room.getRoomNbr(), invalidBed.getBedNbr(), "OHIP", "He's sick", 5);
        Assertions.assertNotNull(patientAdmissionInfo_invalidBed);
    }

    @Given("the provided ward room or bed details are invalid")
    public void the_provided_ward_room_or_bed_details_are_invalid() {

        invalidBed = new Bed(UUID.randomUUID());
        Bed isInRepository = bedRepositoryStub.find(invalidBed.getBedNbr());
        boolean isInWard = false;
        for (UUID roomNbr: ward.getRooms()) {
            Room r = roomRepositoryStub.find(roomNbr);
            UUID[] bedNbrs = r.getBeds();
            for (UUID bedNbr: bedNbrs) {
                Bed b = bedRepositoryStub.find(bedNbr);
                if (b.getBedNbr() == invalidBed.getBedNbr()) isInWard = true;
            }
        }
        Assertions.assertTrue(isInRepository == null || !isInWard);
    }

    @Given("the charge nurse has a patient selected from the request list")
    public void the_charge_nurse_has_a_patient_selected_from_the_request_list() {
        // Implementation for selecting a patient from the request list
    }

    @Given("the necessary admission information is provided")
    public void the_necessary_admission_information_is_provided() {
        // Verify that all necessary admission information is provided
    }

    @Given("the patient cannot be admitted for any reason")
    public void the_patient_cannot_be_admitted_for_any_reason() {
        // Check if there's a reason preventing patient admission
    }

    @Given("the medical staff member provides invalid or incomplete patient information")
    public void the_medical_staff_member_provides_invalid_or_incomplete_patient_information() {
        // Implement logic to validate the patient information provided by the medical staff member, checking for completeness and correctness
    }

    @Given("necessary room, bed, or additional admission information is missing")
    public void necessary_room_bed_or_additional_admission_information_is_missing() {
        // Check if room, bed, or additional admission information is missing
    }

    @Given("a medical staff member is logged in")
    public void a_medical_staff_member_is_logged_in() {
        // Implementation for verifying medical staff member login
    }

    @Given("the staff member has provided a valid patient identification number")
    public void the_staff_member_has_provided_a_valid_patient_identification_number() {
        // Verify that a valid patient ID is provided
    }

    @Given("the staff member has provided an invalid patient identification number")
    public void the_staff_member_has_provided_an_invalid_patient_identification_number() {
        // Check if an invalid patient ID is provided
    }

    @Given("the patient is currently admitted to a ward")
    public void the_patient_is_currently_admitted_to_a_ward() {
        // Check if the patient is currently admitted to a ward
    }

    @Given("the patient is not currently admitted to a ward")
    public void the_patient_is_not_currently_admitted_to_a_ward() {
        // Check if the patient is not currently admitted to a ward
    }

    @Given("the medical staff member provides valid and complete patient information")
    public void the_medical_staff_member_provides_valid_and_complete_patient_information() {
        // Verify that valid and complete patient information is provided
    }

    @Given("the Local Doctor ID matches a doctor in the HMS")
    public void the_local_doctor_id_matches_a_doctor_in_the_hms() {
        // Check if the Local Doctor ID matches a doctor in the HMS
    }

    @Given("the provided patient details match an existing patient in the HMS")
    public void the_provided_patient_details_match_an_existing_patient_in_the_hms() {
        // Check if provided patient details match an existing patient in the HMS
    }

    @Given("the provided patient information is incomplete or invalid")
    public void the_provided_patient_information_is_incomplete_or_invalid() {
        // Verify if the provided patient information is incomplete or invalid
    }

    @Given("the charge nurse selects the patient for admission")
    public void the_charge_nurse_selects_the_patient_for_admission() {
        // Logic for the charge nurse selecting a patient for admission
    }

    @Given("the charge nurse provides complete and valid admission request information")
    public void the_charge_nurse_provides_complete_and_valid_admission_request_information() {
        // Verify that complete and valid admission request information is provided
    }

    @Given("the patient is not currently admitted to any ward")
    public void the_patient_is_not_currently_admitted_to_any_ward() {
        // Check if the patient is not currently admitted to any ward
    }

    @Given("the admission request information is incomplete or invalid")
    public void the_admission_request_information_is_incomplete_or_invalid() {
        // Verify if the admission request information is incomplete or invalid
    }

    @Given("the staff member is viewing a patient’s file")
    public void the_staff_member_is_viewing_a_patients_file() {
        // Implementation for a staff member viewing a patient's file
    }

    @Given("the staff member enters valid modifications to the patient's information")
    public void the_staff_member_enters_valid_modifications_to_the_patients_information() {
        // Logic to handle entry of valid modifications to the patient's information
    }

    @Given("the staff member enters invalid modifications with invalid information")
    public void the_staff_member_enters_invalid_modifications_with_invalid_information() {
        // Check if modifications entered by the staff member are invalid
    }

    @Given("the medical staff does not have authorization to update patient files")
    public void the_medical_staff_does_not_have_authorization_to_update_patient_files() {
        // Check if the medical staff does not have authorization to update patient files
    }

    // When steps
    @When("the charge nurse submits the admission form")
    public void the_charge_nurse_submits_the_admission_form() {
        wardFacade = new WardFacadeImpl(wardRepositoryStub, roomRepositoryStub, bedRepositoryStub,
                patientRepositoryStub, admissionFactoryStub, admissionRequestFactoryStub, dischargeFactoryStub,
                eventEmitterStub);
        Assertions.assertNotNull(wardFacade);
    }

    @When("the charge nurse submits the admission form from the request list")
    public void the_charge_nurse_submits_the_admission_form_from_the_request_list() {
        // Logic for submitting the admission form from the request list
    }

    @When("the staff member requests to view the patient's file")
    public void the_staff_member_requests_to_view_the_patients_file() {
        // Implementation for a staff member requesting to view a patient's file
    }

    @When("the charge nurse initiates the discharge process")
    public void the_charge_nurse_initiates_the_discharge_process() {
        // Logic for the charge nurse initiating the discharge process
    }

    @When("the staff member submits the patient registration form")
    public void the_staff_member_submits_the_patient_registration_form() {
        // Implementation for submitting the patient registration form
    }

    @When("the charge nurse submits the admission request")
    public void the_charge_nurse_submits_the_admission_request() {
        // Logic for the charge nurse submitting the admission request
    }

    @When("the staff member submits the update request")
    public void the_staff_member_submits_the_update_request() {
        // Logic for the staff member submitting the update request
    }

    // Then steps
    @Then("the system admits the patient to the selected bed in the ward")
    public void the_system_admits_the_patient_to_the_selected_bed_in_the_ward() {
        boolean result = wardFacade.admitPatient(ward.getWardId(), patientAdmissionInfo);
        Assertions.assertTrue(result);
    }

    @Then("the system updates bed availability and patient information")
    public void the_system_updates_bed_availability_and_patient_information() {
        UUID bedNbr = patientAdmissionInfo.getBedNumber();
        Bed bed = bedRepositoryStub.find(bedNbr);
        Assertions.assertEquals("complete", bed.getStatus());
    }

    @Then("the system notifies the charge nurse of the full status")
    public void the_system_notifies_the_charge_nurse_of_the_full_status() {
        boolean result = wardFacade.admitPatient(wardFull.getWardId(), patientAdmissionInfo);
        Assertions.assertFalse(result); //For now we deal with bool values
    }

    @Then("the system displays an error message indicating invalid room and bed details")
    public void the_system_displays_an_error_message_indicating_invalid_room_bed_details() {
        boolean result = wardFacade.admitPatient(ward.getWardId(), patientAdmissionInfo_invalidBed);
        Assertions.assertFalse(result); //For now we deal with bool values
    }

    // Admit Patient from Request List Feature
    @Then("the patient is admitted from the request list to the specified bed in the ward")
    public void the_patient_is_admitted_from_the_request_list_to_the_specified_bed_in_the_ward() {
        // Implement logic to verify admission of a patient from the request list
    }

    @Then("the patient is removed from the request list")
    public void the_patient_is_removed_from_the_request_list() {
        // Implement logic to remove the patient from the request list
    }

    @Then("the system sends a notification to the charge nurse who originally requested the admission")
    public void the_system_sends_a_notification_to_the_charge_nurse_who_originally_requested_the_admission() {
        // Implement logic to notify the charge nurse who requested the admission
    }

    @Then("the system displays a message indicating the patient admission has been denied")
    public void the_system_displays_a_message_indicating_the_patient_admission_has_been_denied() {
        // Implement logic to display a message indicating admission denial
    }

    // Consult Patient File Feature
    @Then("the system retrieves the patient's registration information")
    public void the_system_retrieves_the_patients_registration_information() {
        // Implement logic to verify retrieval of patient's registration information
    }

    @Then("the system alerts that the patient ID is not recognized")
    public void the_system_alerts_that_the_patient_id_is_not_recognized() {
        // Implement logic to alert when a patient ID is not recognized
    }

    @Then("the system prevents any patient file from being displayed")
    public void the_system_prevents_any_patient_file_from_being_displayed() {
        // Implement logic to prevent any patient file from being displayed on invalid ID
    }

    // Discharge Patient Feature
    @Then("the system discharges the patient from the hospital")
    public void the_system_discharges_the_patient_from_the_hospital() {
        // Implement logic to verify the discharge of a patient from the hospital
    }

    @Then("the system displays an error message that the patient is not admitted")
    public void the_system_displays_an_error_message_that_the_patient_is_not_admitted() {
        // Implement logic to display an error message when a non-admitted patient is discharged
    }

    // Register Patient Feature
    @Then("the system registers the patient with the provided information")
    public void the_system_registers_the_patient_with_the_provided_information() {
        // Implement logic to verify patient registration with provided information
    }

    @Then("the system displays a error message indicating the patient already exists")
    public void the_system_displays_a_error_message_indicating_the_patient_already_exists() {
        // Implement logic to display an error message for duplicate patient details
    }

    // Request Patient Admission Feature
    @Then("the system places the patient on the waiting list for admission")
    public void the_system_places_the_patient_on_the_waiting_list_for_admission() {
        // Implement logic to place the patient on the waiting list for admission
    }

    // Update Patient File Feature
    @Then("the system saves the modifications to the patient’s file")
    public void the_system_saves_the_modifications_to_the_patients_file() {
        // Implement logic to save modifications to the patient's file
    }

    @Then("the system rejects the modifications")
    public void the_system_rejects_the_modifications() {
        // Implement logic to reject modifications to the patient's file on invalid information
    }

    @Then("the system displays an error message about the unauthorized operation")
    public void the_system_displays_an_error_message_about_the_unauthorized_operation() {
        // Implement logic to display an error message for unauthorized file updates
    }

    @Then("the system displays the patient's file to the staff member")
    public void the_system_displays_the_patients_file_to_the_staff_member() {

    }

    @Then("the system logs the successful access attempt")
    public void the_system_logs_the_successful_access_attempt () {

    }

    @Then("the system logs the unsuccessful access attempt")
    public void the_system_logs_the_unsuccessful_access_attempt () {

    }

    @Then("updates the bed availability of the ward")
    public void updates_the_bed_availability_of_the_ward() {
        // Implement logic to update the bed availability in the specified ward
    }

    @Then("generates discharge information")
    public void generates_discharge_information() {
        // Implement logic to generate and compile discharge information for the patient
    }

    @Then("sends a copy of the discharge information to the patient's external doctor")
    public void sends_a_copy_of_the_discharge_information_to_the_patients_external_doctor() {
        // Implement logic to send a copy of the discharge information to the patient's external doctor
    }

    @Then("displays a successful discharge confirmation message")
    public void displays_a_successful_discharge_confirmation_message() {
        // Implement logic to display a confirmation message upon successful patient discharge
    }

    @Then("the system displays an error message indicating missing or invalid data")
    public void the_system_displays_an_error_message_indicating_missing_or_invalid_data() {
        // Implement logic to display an error message for missing or invalid data during the process
    }

    @Then("assigns a primary Charge Nurse to the patient based on division")
    public void assigns_a_primary_charge_nurse_to_the_patient_based_on_division() {
        // Implement logic to assign a primary Charge Nurse to the patient based on the division of the hospital
    }

    @Then("sends confirmation message to the medical staff member")
    public void sends_confirmation_message_to_the_medical_staff_member() {
        // Implement logic to send a confirmation message to the medical staff member who completed the process
    }

    @Then("confirms the successful placement to the charge nurse")
    public void confirms_the_successful_placement_to_the_charge_nurse() {
        // Implement logic to confirm the successful placement of the patient on the waiting list to the charge nurse
    }

    @Then("does not place the patient on the waiting list")
    public void does_not_place_the_patient_on_the_waiting_list() {
        // Implement logic to handle the scenario where the patient is not placed on the waiting list, including potential reasons and notifications
    }

    @Then("the medical staff does not have authorisation to update patient files")
    public void the_medical_staff_does_not_have_authorisation_to_update_patient_files() {
        // Implement logic to check whether the medical staff has the necessary authorization to update patient files
    }

}
