Feature: Register Patient

  Scenario: Successful Patient Registration by Authorized Medical Staff
    Given a medical staff member is logged in
    And the medical staff member has authorization to register patients
    And the medical staff member provides valid and complete patient information
    When the registerPatient command application is invoked
    Then the system registers the patient, assigning a unique identification number
    And confirms successful registration to the medical staff member

  Scenario: Registration with Duplicate Patient Details
    Given a medical staff member is logged in
    And the medical staff member has authorization to register patients
    And the provided patient details match an existing patient in the system
    When the registerPatient command application is invoked
    Then the system displays a message indicating the patient already exists
    And the registration process is halted
    
  Scenario: Registration with Invalid or Incomplete Data
    Given a medical staff member is logged in
    And the medical staff member has authorization to register patients
    And the provided patient information is incomplete or invalid
    When the registerPatient command application is invoked
    Then the system displays an error message indicating missing or invalid data
    And the patient is not registered
    And the registration process is halted