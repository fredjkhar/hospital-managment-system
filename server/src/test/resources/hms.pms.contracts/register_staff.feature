Feature: Register Staff (Nurse, Doctor, personnel)
  Scenario: Register Staff with existing employee number in the HRS
    Given the user is on the Staff Registration page
    And provided employee number does not exist in the HMS
    And provided employee number is present in the external HRS
    And provided staff information is complete and valid
    When the registerStaff command application is invoked
    Then a new medical staff account is created
    And the new medical staff account is initialized from the staff information
    And the system sends an acknowledgement message to the user confirming the successful registration
    And the new medical staff account is now set to be active

  Scenario: Register Staff with Employee Number Not in HRS
    Given the user is on the Staff Registration page
    And provided employee number does not exist in the HMS
    And provided employee number is not present in the external HRS
    And provided staff information is complete and valid
    When the registerStaff command application is invoked
    Then the system checks the external HRS for the provided employee number
    And the system displays an error message indicating the employee number is not found in the external HRS
    And the registration process is halted

  Scenario: Register Staff with Incomplete Information
    Given the user is on the Staff Registration page
    And provided employee number does not exist in the HMS
    And provided employee number is present in the external HRS
    And provided staff information is incomplete
    When the registerStaff command application is invoked
    Then the system displays an error message indicating that some required fields are missing
    And the registration process is halted
