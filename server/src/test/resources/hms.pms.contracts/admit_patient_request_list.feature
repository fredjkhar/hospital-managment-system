Feature: Admit Patient from Request List
    In order to manage patient flow from the waiting list
    As a Charge Nurse
    I want to admit patients from the request list to the appropriate ward

    Scenario: Successful Patient Admission from the Request List
        Given the charge nurse is logged in
        And the charge nurse has a patient selected from the request list
        And there is an available bed in the specified ward
        And the necessary admission information is provided
        When the charge nurse submits the admission form from the request list
        Then the patient is admitted from the request list to the specified bed in the ward
        And the patient is removed from the request list
        And the system displays a confirmation of successful admission

    Scenario: Denying Patient Admission
        Given the charge nurse is logged in
        And the charge nurse has a patient selected from the request list
        And the patient cannot be admitted for any reason
        When the charge nurse submits the admission form from the request list
        Then the system sends a notification to the charge nurse who originally requested the admission
        And the system displays a message indicating the patient admission has been denied

    Scenario: Admitting Patient with Missing Information
        Given the charge nurse is logged in
        And the charge nurse has a patient selected from the request list
        And the charge nurse is consulting a patient’s file
        And necessary room, bed, or additional admission information is missing
        When the charge nurse submits the admission form from the request list
        Then the system displays an error message indicating missing or invalid data
