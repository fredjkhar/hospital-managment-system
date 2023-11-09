Feature: Visualize Division
  In order to manage division information
  As a Charge Nurse
  I want to view details about my division

  Scenario: Successful division visualization
    Given the charge nurse with ID "CN123" is logged in
    And "DIV456" is a valid division identifier
    When the charge nurse selects to visualize division "DIV456"
    Then the system displays the division name, occupancy status, and patient details for "DIV456"
    And the system lists available beds within the division

  Scenario: Wrong division identifier is entered
    Given the charge nurse with ID "CN123" is logged in
    And "INVALID" is an incorrect division identifier
    When the charge nurse attempts to visualize a division with identifier "INVALID"
    Then the system displays an error message "Division not found. Please enter a valid division identifier."