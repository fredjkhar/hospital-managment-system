Feature: Register Staff

    Scenario: Successful staff member registration
        Given a registered personnel officer is logged in
        When the registerStaffMember command application is invoked
        Then the staff member is successfully registered

    Scenario: Registration with Duplicate Staff Details
        Given a registered personnel officer is logged in
        And a staff member with the same details already exists
        When the registerStaffMember command application is invoked
        Then a message indicates that the staff member already exists

    Scenario: Registration with Invalid Data
        Given a registered personnel officer is logged in
        And the input data for the new staff member is invalid
        When the registerStaffMember command application is invoked
        Then an error message is displayed, and the staff member is not registered
