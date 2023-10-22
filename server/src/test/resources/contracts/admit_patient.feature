Feature: Admit Patient
	Scenario: Successful patient admission by Charge Nurse
		Given a charge nurse is logged in
			And the division is not complete (has spaces available)
		When the application command admitPatient is executed
		Then the patient is admitted to the division
	Scenario: Unsuccessful due to complete Division
		Given a charge nurse is logged in
		And the division is complete (no spaces available)
		When the application command admitPatient is executed
		Then the HMS notifies that the division is complete
		And that the patient was not admitted
		And gives possibility to request a patient admission
