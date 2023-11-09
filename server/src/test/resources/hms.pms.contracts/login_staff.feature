Feature: Staff Log In to HMS
  In order to access HMS functions
  As a Staff Member
  I want to log in to the HMS

  Scenario: Staff Member Logs In with Valid Credentials
    Given the user is on the Staff Login page
    And the user has an active account in the HMS
    And the user enters valid and complete login information
    When the user submits the login form
    Then the system logs the login attempt
    And the system redirects the user to the corresponding dashboard based on their role
    And the system displays the dashboard relevant to the user's role

  Scenario: Staff Member Logs In with Invalid Credentials
    Given the user is on the Staff Login page
    And the user enters invalid but complete login information
    When the user submits the login form
    And the system displays an error message indicating invalid login credentials

  Scenario: Staff Member Logs In with Incomplete Information
    Given the user is on the Staff Login page
    And the user login information is incomplete
    When the user submits the login form
    Then the system checks the login information completeness
    And the system displays an error message indicating missing required fields

  Scenario: Staff Member is not registered
    Given the user is on the Staff Login page
    And the user login information does not match any registered account in the HMS
    And the user login information is valid and complete
    When the user submits the login form
    Then the system attempts to match the login information with a registered account
    And the system displays an error message indicating the user is not registered
