Feature: Staff Log In to HMS
  Scenario: Staff Member Logs In with Valid Credentials
    Given the user is on the Staff Login page
    And the user has an active account in the HMS
    And the user login information is valid and complete
    When the loginStaff command application is invoked
    Then the system checks the user's authorization status
    And displays the Staff’s operation choices with the corresponding privileges

  Scenario: Staff Member Logs In with Invalid Credentials
    Given the user is on the Staff Login page
    And the user has an active account in the HMS
    And the user login information is invalid but complete
    When the loginStaff command application is invoked
    Then the system attempts to validate the login information
    And displays an error message indicating invalid login credentials
    And the login process is halted

  Scenario: Staff Member Logs In with Incomplete Information
    Given the user is on the Staff Login page
    And the user has an active account in the HMS
    And the user login information is incomplete
    When the loginStaff command application is invoked
    Then the system checks the login information completeness
    And displays an error message indicating missing required fields
    And the login process is halted

  Scenario: Staff Member is not registered
    Given the user is on the Staff Login page
    And the user login information does not match any registered account in the HMS
    And the user login information is valid and complete
    When the loginStaff command application is invoked
    Then the system attempts to match the login information with a registered account
    And displays an error message indicating the user is not registered
    And the login process is halted
