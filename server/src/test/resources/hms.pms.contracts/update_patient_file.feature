Feature: Update Patient File

  Scenario: Successful Patient File Update by Authorized Staff
    Given a staff member is logged in
    And the staff member has authorization to update patient files
    And the staff member is consulting a patient’s file
    And the staff member makes valid modifications to the patient's information
    When the updatePatientFile command application is invoked
    Then the system updates the patient’s file with the modified information
    And confirms the successful update to the medical staff member

  Scenario: Update Patient File with Invalid Information
    Given a staff member is logged in
    And the staff member has authorization to update patient files
    And the staff member is consulting a patient’s file
    And the staff member makes valid modifications to the patient's information
    When the updatePatientFile command application is invoked
    Then the system displays an error message indicating invalid information
    And does not update the patient’s file
    And the updatePatientFile process is halted

  Scenario: Update Patient File without Authorization
    Given a medical staff member is logged in
    And the medical staff member does not have authorization to update patient files
    And the medical staff member is consulting a patient’s file
    And the medical staff member attempts to update the patient’s file
    When the updatePatientFile command application is invoked
    Then the system displays an error message indicating a lack of authorization and denies the modification
    And does not update the patient’s file
    And the updatePatientFile process is halted