Feature: Register Patient

  Scenario: Successful patient registration
    Given a registered medical staff member is logged in
    And the patient information is provided
    When the registerPatient command application is invoked
    Then the patient is successfully registered

  Scenario: Registration with Duplicate Patient Details
    Given a registered medical staff member is logged in
    And a patient with the same details already exists
    When the registerPatient command application is invoked
    Then a message indicates that the patient already exists

  Scenario: Registration with Invalid Data
    Given a registered medical staff member is logged in
    And the patient information is incomplete or invalid
    When the registerPatient command application is invoked
    Then an error message is displayed, and the patient is not registered
