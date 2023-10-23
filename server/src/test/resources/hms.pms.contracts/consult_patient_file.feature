Feature: Consult Patient File

  Scenario: Successful Access to Patient File by Authorized Staff
    Given a staff member is logged in
    And the staff member has authorization to access patient files
    And the patient identification number is provided
    When the consultPatientFile command application is invoked
    Then the system retrieves the patient's registration information
    And displays the patient's file to the staff member

  Scenario: Access Patient File with Invalid Patient ID
    Given a staff member is logged in
    And the staff member has authorization to access patient files
    And the staff member specifies an invalid patient identification number
    When the consultPatientFile command application is invoked
    Then the system displays an error message indicating that the patient ID is not found
    And does not display any patient file
    And the consultPatientFile process is halted

  Scenario: Access Patient File without Authorization
    Given a staff member is logged in
    And the staff member does not have authorization to access patient files
    And the patient identification number is provided
    When the consultPatientFile command application is invoked
    Then the system displays an error message indicating a lack of authorization
    And does not display any patient file
    And the consultPatientFile process is halted

