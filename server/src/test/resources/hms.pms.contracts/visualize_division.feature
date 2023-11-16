Feature: Visualize Ward
  In order to manage ward information
  As a Charge Nurse
  I want to view details about my ward

  Scenario: Successful ward visualization
    Given the charge nurse with ID "CN123" is logged in
    And "DIV456" is a valid ward identifier
    When the charge nurse selects to visualize ward "DIV456"
    Then the system displays the ward name, occupancy status, and patient details for "DIV456"
    And the system lists available beds within the ward

  Scenario: Wrong ward identifier is entered
    Given the charge nurse with ID "CN123" is logged in
    And "INVALID" is an incorrect ward identifier
    When the charge nurse attempts to visualize a ward with identifier "INVALID"
    Then the system displays an error message "Ward not found. Please enter a valid ward identifier."
