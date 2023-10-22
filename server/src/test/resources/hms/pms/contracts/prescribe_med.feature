Feature: Prescribe Medication

    Scenario: Successful prescription of medication
        Given a doctor is logged in
        When the prescribeMedication command application is invoked
        Then the prescription is recorded in the patient's file

    Scenario: Prescription of Invalid Medication
        Given a doctor is logged in
        And the medication to be prescribed is invalid
        When the prescribeMedication command application is invoked
        Then an error message indicates an invalid prescription

    Scenario: Prescription by Unauthorized User
        Given a non-doctor staff member is logged in
        When the prescribeMedication command application is invoked
        Then an error message indicates a lack of prescription authority
