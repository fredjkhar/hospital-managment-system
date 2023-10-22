Feature: Admit Patient from Request List
	Scenario: Successful patient admission from the request list
		Given a charge nurse is logged in
		And a patient is in the request list for admission
		When the application command admitPatient is executed
		Then the patient is admitted to the division
	Scenario: Unsuccessful patient admission
		Given a charge nurse is logged in
		And a patient is in the request list for admission
		When the application command admitPatient is executed
		And (other) charge nurse denies patient admission
		Then Patient is not admitted
		And Charge nurse that requested admission is notified
