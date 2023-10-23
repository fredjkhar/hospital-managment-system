Feature: Visualize Division

  Scenario: Successful division visualization
    Given a charge nurse with ID "CN123" is logged in
    And the correct division identifier "DIV456" is entered
    When the charge nurse invokes the visualizeDivision command application
    Then division "DIV456" information is displayed
    And the division information includes the division name, occupancy status, and patient details

  Scenario: Wrong division identifier is entered
    Given a charge nurse with ID "CN123" is logged in
    And an incorrect division identifier "INVALID" is entered
    When the charge nurse attempts to visualize a division using the visualizeDivision command application
    Then an error message is displayed, indicating "Division not found. Please enter a valid division identifier."
    And the charge nurse is prompted to re-enter a valid division identifier

  Scenario: Unauthorized Division Visualization
    Given a non-charge nurse staff member with ID "STAFF456" is logged in
    And a correct division identifier "DIV789" is entered
    When they attempt to visualize a division using the visualizeDivision command application
    Then an error message is displayed, indicating "Unauthorized access. Only charge nurses can visualize divisions."
    And the division visualization request is denied