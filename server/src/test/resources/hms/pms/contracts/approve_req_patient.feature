Feature: Admit Patient from Request List

    Scenario: Successful patient admission from the request list
        Given a charge nurse is logged in
        And a patient is in the request list for admission
        When the admitPatientFromRequestList command application is invoked
        Then the patient is admitted to the division

    Scenario: Admit Non-Request List Patient
        Given a charge nurse is logged in
        And no patient is in the request list
        When the admitPatientFromRequestList command application is invoked
        Then a message indicates that there are no patients in the request list

    Scenario: Admit Patient by Unauthorized User
        Given a non-charge nurse staff member is logged in
        When the admitPatientFromRequestList command application is invoked
        Then an error message indicates a lack of authorization
