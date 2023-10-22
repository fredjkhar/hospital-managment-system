Feature: Admit Patient
    
    Scenario: Successful patient admission by Charge Nurse
        Given a charge nurse is logged in
        When the charge nurse admits the patient from the request list
        Then the patient is admitted to the division
    
    Scenario: Admission without Patient in Request List
        Given a charge nurse is logged in
        And there is no patient in the request list
        When the charge nurse attempts to admit a patient
        Then a message indicates that there are no patients to admit
    
    Scenario: Unauthorized Admission
        Given a non-charge nurse staff member is logged in
        When they attempt to admit a patient
        Then an error message indicates a lack of authorization
