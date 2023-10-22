Feature: Request Patient Admission

  Scenario: Successful patient admission request
    Given a charge nurse is logged in
    And the patient's admission request information is provided
    When the requestPatientAdmission command application is invoked
    Then the patient is added to the waiting list for admission

  Scenario: Admission Request with Incomplete Information
    Given a charge nurse is logged in
    And the patient's admission request information is incomplete or invalid
    When the requestPatientAdmission command application is invoked
    Then an error message is displayed, and the patient is not added to the waiting list

  Scenario: Admission Request by Unauthorized User
    Given a non-charge nurse staff member is logged in
    When they attempt to request patient admission
    Then an error message indicates a lack of authorization
