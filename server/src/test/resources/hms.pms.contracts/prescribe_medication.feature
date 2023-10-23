Feature: Prescribe Medication

    Scenario: Successful Prescription of Medication
        Given a doctor is logged in
        And the doctor is consulting a patient’s file
        And the patient is under the care of the doctor
        And the required prescription medication is provided
        When the prescribeMedication command application is invoked
        Then a prescription is created a filled with the provided information
        And the system associates the prescription with the correct patient
        And the system displays a confirmation message indicating successful prescription

    Scenario: Prescription for Patient Not Under Care
        Given a doctor is logged in
        And the doctor is consulting a patient’s file
        And the patient is not under the care of the doctor
        And the required prescription medication is provided
        When the prescribeMedication command application is invoked
        Then tthe system displays an error message indicating that the patient is not under the care of the doctor
        And prevents the prescription creation
        And prevents the association of the prescription with the selected patient
        And the prescription process is halted

    Scenario: Prescription by Unauthorized User
        Given a non-doctor staff member is logged in
        And the medical staff is consulting a patient’s file
        And the required prescription medication is provided
        When the prescribeMedication command application is invoked
        Then the system displays an error message indicating a lack of prescription authority
        And the prescription process is halted
