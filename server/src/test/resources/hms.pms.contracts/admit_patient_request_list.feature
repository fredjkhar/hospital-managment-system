Feature: Admit Patient from Request List
    In order to manage patient flow from the waiting list
    As a Charge Nurse
    I want to admit patients from the request list to the appropriate ward

    Scenario: Successful Patient Admission from the Request List
        Given a charge nurse is logged in and has a patient selected from the request list
        And the selected patient's file is open
        And the specified ward has an available bed
        And the remaining admission information is provided
        When the charge nurse submits the admission form
        Then the patient is admitted from the request list to the specified bed in the ward
        And the patient is removed from the request list
        And the system confirms successful admission

    Scenario: Admit Non-Request List Patient
        Given a charge nurse is logged in and the request list is empty
        When the charge nurse attempts to admit a patient from the request list
        Then the system indicates that there are no patients on the request list
        And the admission process is halted

    Scenario: Denying Patient Admission
        Given the charge nurse is logged in
        And the charge nurse has a patient selected from the request list
        And the charge nurse is consulting the patient’s file
        And the patient cannot be admitted for any reason
        When the charge nurse initiates the deny admission process from the request list
        Then the system sends a notification to the charge nurse who originally requested the admission
        And updates the request list to indicate the denial
        And the system displays a message indicating the patient admission has been denied
        And the admission process for the patient is halted

    Scenario: Admitting Patient with Missing Information
        Given the charge nurse is logged in
        And the charge nurse has a patient selected from the request list
        And the charge nurse is consulting the patient’s file
        And necessary room, bed, or additional admission information is missing
        When the charge nurse initiates the admission process from the request list
        Then the system displays an error message indicating missing information
        And prompts the charge nurse to provide the necessary details
        And the patient admission process is halted
