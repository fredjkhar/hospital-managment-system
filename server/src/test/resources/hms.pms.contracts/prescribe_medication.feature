Feature: Prescribe Medication
    In order to prescribe medication to patients
    As a Doctor
    I want to add prescriptions to the patient's medical file in the HMS

    Scenario: Successful Prescription of Medication
        Given a doctor is logged in and is consulting the patient’s file
        And the patient is under the care of the doctor
        And the prescription details are provided
        When the doctor submits the prescription form
        Then the system creates and associates the prescription with the patient
        And the prescription is time-stamped and recorded in the patient's medical file
        And displays a confirmation message of successful prescription

    Scenario: Prescription for Patient Not Under Care
        Given a doctor is logged in and is consulting the patient’s file
        And the patient is not under the care of the doctor
        And prescription details are provided
        When the doctor submits the prescription form
        Then the system displays an error message that the patient is not under the doctor's care
        And the prescription process is halted
