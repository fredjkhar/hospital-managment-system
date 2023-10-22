Feature: Staff Log Out of HMS
  Scenario: Staff Member Logs Out
    Given the Staff Member is currently logged into the HMS
    When the logoutStaff command application is invoked
    Then the system terminates the Staff Member's active session
    And the system redirects the Staff Member to the HMS login page
    And displays a confirmation message indicating successful log out
    