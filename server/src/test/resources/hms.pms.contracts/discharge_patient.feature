Feature: Discharge Patient
    In order to manage the discharge of patients from the hospital
    As a Charge Nurse
    I want to discharge patients and update the hospital records accordingly

    Scenario: Successful Patient Discharge
        Given the charge nurse is logged in
        And the charge nurse is consulting a patient’s file
        And the patient is currently admitted to a ward
        When the charge nurse initiates the discharge process
        Then the system discharges the patient from the hospital
        And updates the bed availability of the ward
        And generates discharge information
        And sends a copy of the discharge information to the patient's external doctor
        And displays a successful discharge confirmation message

    Scenario: Discharge Non-Admitted Patient
        Given the charge nurse is logged in
        And the charge nurse is consulting a patient’s file
        And the patient is not currently admitted to a ward
        When the charge nurse initiates the discharge process
        Then the system displays an error message that the patient is not admitted
