Feature: Admit Patient
    In order to admit patients to the hospital
    As a Charge Nurse
    I want to assign patients to a specific ward, room, and bed

    Scenario: Successful Patient Admission by Charge Nurse
        Given the charge nurse is logged in
        And is consulting a patient’s file
        And there is an available bed in the specified ward
        And the charge nurse selects the available room and bed
        And enters all remaining admission information
        When the charge nurse submits the admission form
        Then the system admits the patient to the selected bed in the ward
        And updates bed availability and patient information
        And displays a confirmation of successful admission

    Scenario: Ward is Full
        Given the charge nurse is logged in
        And is consulting a patient’s file
        And the specified ward is full
        When the charge nurse attempts to admit a patient to the specified ward
        Then the system notifies the charge nurse of the full status
        And suggests initiating a patient admission request

    Scenario: Admission with Invalid Room/Bed Details
        Given a charge nurse is logged in
        And is consulting a patient’s file
        And there is an available bed in the specified ward
        And the provided ward room or bed details are invalid
        When the charge nurse attempts to admit a patient to the specified ward
        Then the system displays an error message indicating invalid room/bed details
        And requests valid room and bed details again
