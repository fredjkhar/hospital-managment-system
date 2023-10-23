Feature: Discharge Patient
    Scenario: Successful Patient Discharge
        Given a charge nurse is logged in
        And the charge nurse is consulting a patient’s file
        And the patient is currently admitted to a ward
        When the dischargePatient command application is invoked
        Then the patient is discharged from the hospital
        And the bed availability information for the ward is updated
        And discharge information is generated and issued
        And a copy of the discharge information is sent to the patient's external doctor
        And the system displays a confirmation message indicating successful discharge

    Scenario: Discharge Non-Admitted Patient
        Given a charge nurse is logged in
        And the charge nurse is consulting a patient’s file
        And the patient is not currently admitted
        When the dischargePatient command application is invoked
        Then the system displays a error message indicating that the patient is not admitted
        And the discharge process is halted

    Scenario: Discharge Patient without Authorization
        Given a non-charge nurse staff member is logged in
        And the staff member is consulting a patient’s file
        When the dischargePatient command application is invoked
        Then the system displays an error message indicating a lack of authorization
        And the discharge process is halted

