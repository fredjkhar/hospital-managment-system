Feature: Update Patient File
  In order to maintain accurate patient records
  As a Medical Staff Member
  I want to update patient files with new information

  Scenario: Successful Patient File Update by Authorized Staff
    Given a medical staff member is logged in
    And the staff member is viewing a patient’s file
    And the staff member enters valid modifications to the patient's information
    When the staff member submits the update request
    Then the system saves the modifications to the patient’s file

  Scenario: Update Patient File with Invalid Information
    Given a medical staff member is logged in
    And the staff member is viewing a patient’s file
    And the staff member enters invalid modifications with invalid information
    When the staff member submits the update request
    Then the system rejects the modifications
    And the system displays an error message indicating missing or invalid data

  Scenario: Update Patient File without Authorization
    Given a medical staff member is logged in
    And the medical staff does not have authorisation to update patient files
    And the staff member is viewing a patient’s file
    When the staff member submits the update request
    Then the system displays an error message about the unauthorized operation
