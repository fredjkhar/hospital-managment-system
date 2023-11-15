Feature: Register Staff
  In order to manage hospital staff access to the HMS
  As a Staff Member
  I want to register my account in the HMS

  Scenario: Register Staff with existing employee number in the HRS
    Given the user is on the Staff Registration page
    And provided employee number exists in the external HRS
    And no existing account with the provided employee number exists in the HMS
    And provided staff information is complete and valid
    When the user submits the registration form
    Then the system creates a new staff account with the provided information
    And assigns the staff role based on external HRS role data
    And sends an acknowledgement message with login details

  Scenario: Register Staff with Employee Number Not in HRS
    Given the user is on the Staff Registration page
    And provided employee number does not exist in the external HRS
    When the user submits the registration form
    Then the system displays an error message indicating the employee number is not found in the external HRS

  Scenario: Register Staff with Incomplete Information
    Given the user is on the Staff Registration page
    And provided staff information is incomplete
    When the user submits the registration form
    Then the system displays an error message indicating that some required fields are missing
