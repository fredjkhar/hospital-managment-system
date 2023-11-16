Feature: Register Patient
  In order to manage patient records
  As a Medical Staff Member
  I want to register new patients in the HMS

  Scenario: Successful Patient Registration by Authorized Medical Staff
    Given a medical staff member is logged in
    And the medical staff member provides valid and complete patient information
    And the Local Doctor ID matches a doctor in the HMS
    When the staff member submits the patient registration form
    Then the system registers the patient with the provided information
    And assigns a primary Charge Nurse to the patient based on the ward
    And sends a confirmation message to the medical staff member

  Scenario: Registration with Duplicate Patient Details
    Given a medical staff member is logged in
    And the provided patient details match an existing patient in the HMS
    When the staff member submits the patient registration form
    Then the system displays a message indicating the patient already exists

  Scenario: Registration with Invalid or Incomplete Data
    Given a medical staff member is logged in
    And the provided patient information is incomplete or invalid
    When the staff member submits the patient registration form
    Then the system displays an error message indicating missing or invalid data
