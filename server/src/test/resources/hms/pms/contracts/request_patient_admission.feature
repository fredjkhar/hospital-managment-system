Feature: Request Patient Admission

  Scenario: Successful Patient Admission Request by Authorized Charge Nurse
    Given a charge nurse is logged in
    And the charge nurse has authorization to request patient admissions
    And the charge nurse provides complete and valid patient admission request information
    When the requestPatientAdmission command application is invoked
    Then the system adds the patient to the waiting list for admission
    And confirms the successful addition to the waiting list to the charge nurse
    
  Scenario: Patient Admission Request with Incomplete or Invalid Information
    Given a charge nurse is logged in
    And the charge nurse has authorization to request patient admissions
    And the provided patient admission request information is incomplete or invalid
    When the requestPatientAdmission command application is invoked
    Then the system displays an error message indicating missing or invalid data
    And the patient is not added to the waiting list
    And the requestPatientAdmission process is halted
    
  Scenario: Patient Admission Request without Authorization
    Given a staff member is logged in
    And the staff member does not have authorization to request patient admissions
    When the staff member attempts to request patient admission
    Then the system displays an error message indicating a lack of authorization
    And denies the admission request
    And the requestPatientAdmission process is halted