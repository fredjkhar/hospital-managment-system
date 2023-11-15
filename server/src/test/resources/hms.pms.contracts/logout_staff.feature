Feature: Staff Log Out of HMS
  In order to securely end my session
  As a Staff Member
  I want to log out of the HMS

  Scenario: Staff Member Logs Out
    Given the Staff Member is currently logged into the HMS
    When the user initiates the logout process
    Then the system logs the logout attempt
    And the system terminates the Staff Member's active session
    And the system clears any session-specific data
    And the system redirects the Staff Member to the HMS login page
