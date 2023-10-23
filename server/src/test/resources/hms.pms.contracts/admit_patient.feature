Feature: Admit Patient
    Scenario: Successful Patient Admission by Charge Nurse
        Given a charge nurse is logged in
        And the charge nurse is consulting a patient’s file
        And the specific ward is not full
        And the specific ward room is selected
        And the specific ward room bed is selected
        And the remaining admission information is selected (rationaleForRequest, localDoctor,...)
        When the admitPatient command application is invoked
        Then the patient is admitted to the chosen ward
        And the patient is admitted to the chosen ward room
        And the patient is admitted to the chosen ward room bed
        And the system updates all relevant patient and division data
        And the system displays a confirmation message indicating successful admission

    Scenario: Division is Full
        Given a charge nurse is logged in
        And the charge nurse is consulting a patient’s file
        And the patient file exists
        And the specific ward is full
        When the admitPatient command application is invoked
        Then the system notifies the charge nurse that the division is full
        And provides the option to initiate a patient admission request
        And the patient admission process is halted

    Scenario: Admission with Invalid Room/Bed Details
        Given a charge nurse is logged in
        And the charge nurse is consulting a patient’s file
        And the patient file exists
        And the specific ward is not full
        And the provided ward room or bed details are invalid
        When the admitPatient command application is invoked
        Then the system displays an error message indicating invalid room/bed details
        And requests valid room and bed details again
        And the patient admission process is halted

    Scenario: Unauthorized Admission
        Given a non-charge nurse staff member is logged in
        And the staff member is consulting a patient’s file
        And the patient file exists
        When the admitPatient command application is invoked
        Then the system displays an error message indicating a lack of authorization
        And the patient admission process is halted
