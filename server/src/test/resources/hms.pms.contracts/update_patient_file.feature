Feature: Update Patient File
  In order to maintain accurate patient records
  As a Medical Staff Member
  I want to update patient files with new information

  Scenario: Successful Patient File Update by Authorized Staff
    Given a medical staff member with update permissions is logged in
    And the staff member is viewing a patient’s file
    And the staff member enters valid modifications to the patient's information
    When the staff member submits the update request
    Then the system saves the modifications to the patient’s file
    And the system confirms the successful update

  Scenario: Update Patient File with Invalid Information
    Given a medical staff member with update permissions is logged in
    And the staff member is viewing a patient’s file
    And the staff member enters modifications with invalid information
    When the staff member submits the update request
    Then the system rejects the modifications
    And the system displays an error message about the invalid information
    And the update process is stopped

  Scenario: Update Patient File without Authorization
    Given a medical staff member without update permissions is logged in
    And the staff member is viewing a patient’s file
    And the staff member attempts to make modifications
    When the staff member submits the update request
    Then the system blocks the update
    And the system notifies the staff member of insufficient permissions
    And the update process is stopped
