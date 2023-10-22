Feature: Admit Patient
	Scenario: Successful patient admission by Charge Nurse
		Given a charge nurse is logged in
			And the division is not complete (has spaces available)
		When the charge nurse admits the patient
		Then the patient is admitted to the division
	Scenario: Unsuccessful due to complete Division
		Given a charge nurse is logged in
		And the division is complete (no spaces available)
		When the charge nurse attempts to admit the patient
		Then the HMS notifies that the division is complete
		And gives possibility to request a patient admission
