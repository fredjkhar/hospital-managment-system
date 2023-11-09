Feature: Request Patient Admission
  In order to manage patient admissions efficiently
  As a Charge Nurse
  I want to be able to put patients on a waiting list for admission

  Scenario: Successful Patient Admission Request by Authorized Charge Nurse
    Given the charge nurse is logged in and has selected a patient for admission
    And the charge nurse provides complete and valid admission request information
    And the patient is not currently admitted to any ward
    When the admission request is submitted
    Then the system places the patient on the waiting list for admission
    And confirms the successful placement to the charge nurse

  Scenario: Patient Admission Request with Incomplete or Invalid Information
    Given the charge nurse is logged in and initiates a patient admission request
    And the admission request information is incomplete or invalid
    When the request is submitted
    Then the system displays an error message indicating missing or invalid data
    And does not place the patient on the waiting list
