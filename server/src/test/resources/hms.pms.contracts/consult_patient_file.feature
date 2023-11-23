Feature: Consult Patient File
  In order to review patient records for medical or administrative purposes
  As a Medical Staff Member
  I want to access and view the content of a patient's file

  Scenario: Successful Access to Patient File
    Given a medical staff member is logged in
    And the staff member has provided a valid patient identification number
    When the staff member requests to view the patient's file
    Then the system retrieves the patient's registration information
    And the system displays the patient's file to the staff member
    And the system logs the successful access attempt

  Scenario: Access Patient File with Invalid Patient ID
    Given a medical staff member is logged in
    And the staff member has provided an invalid patient identification number
    When the staff member requests to view the patient's file
    Then the system alerts that the patient ID is not recognized
    And the system prevents any patient file from being displayed
    And the system logs the unsuccessful access attempt
