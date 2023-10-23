Feature: Admit Patient from Request List

    Scenario: Successful Patient Admission from the Request List
        Given a charge nurse is logged in
        And a patient is in the request list for admission
        And the charge nurse selects the patient from the request list
        And the charge nurse is consulting a patient’s file
        And the patient file exists
        And the specific ward is not full
        And the specific ward room is selected
        And the specific ward room bed is selected
        And the remaining admission information is selected
        When the admitPatientFromRequestList application command is invoked
        Then the patient is admitted to the chosen ward
        And the patient is admitted to the chosen ward room
        And the patient is admitted to the chosen ward room bed
        And the system updates all relevant patient and division data
        And the system displays a confirmation message indicating successful admission

    Scenario: Admit Non-Request List Patient
        Given a charge nurse is logged in
        And no patient is in the request list
        When the admitPatientFromRequestList command application is invoked
        Then the system displays a message indicating that there are no patients in the request list
        And the patient admission from request list process is halted

    Scenario: Admit Patient by Unauthorized User
        Given a non-charge nurse staff member is logged in
        And the staff member selects the patient to be admitted from the list
        When the admitPatientFromRequestList command application is invoked
        Then the system displays an error message indicating a lack of authorization
        And the patient admission process is halted

    Scenario: Denying Patient Admission
        Given a charge nurse is logged in
        And a patient is in the request list for admission
        And the charge nurse selects a patient from the request list
        And the charge nurse is consulting a patient’s file
        And the patient cannot be admitted for any reason
        When the admitPatientFromRequestList command application is invoked
        Then the system sends a notification to the charge nurse who originally requested the admission
        And the system updates the request list
        And the system displays a message indicating the patient admission has been denied
        And the patient admission process is halted

    Scenario: Admitting Patient with Missing Information
        Given a charge nurse is logged in
        And a patient is in the request list for admission
        And the charge nurse selects a patient from the request list
        And the charge nurse is consulting a patient’s file
        And the necessary room, bed, or any additional admission information is missing
        When the admitPatientFromRequestList command application is invoked
        Then the system displays an error message indicating missing information
        And requests the necessary details
        And the patient admission process is halted

