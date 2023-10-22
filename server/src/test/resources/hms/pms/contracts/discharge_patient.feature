Feature: Discharge Patient

    Scenario: Successful patient discharge
        Given a charge nurse is logged in
        When the dischargePatient command application is invoked
        Then the patient is no longer admitted, and discharge information is issued

    Scenario: Discharge Non-Admitted Patient
        Given a charge nurse is logged in
        And the patient is not currently admitted
        When the dischargePatient command application is invoked
        Then a message indicates that the patient is not admitted

    Scenario: Discharge Patient without Authorization
        Given a non-charge nurse staff member is logged in
        When the dischargePatient command application is invoked
        Then an error message indicates a lack of authorization

