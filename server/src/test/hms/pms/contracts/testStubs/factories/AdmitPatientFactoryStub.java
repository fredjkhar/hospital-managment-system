package hms.pms.contracts.testStubs.factories;

import hms.pms.domain.division.entities.Bed;
import hms.pms.domain.division.entities.Room;
import hms.pms.domain.patient.entities.Patient;

public class AdmissionFormFactoryStub implements AdmissionFormFactory {
    @Override
    public AdmissionForm createAdmissionForm(Patient patient, Ward ward, Room room, Bed bed) {
        AdmissionForm admissionForm = new AdmissionForm();
        admissionForm.setPatient(patient);
        admissionForm.setWard(ward);
        admissionForm.setRoom(room);
        admissionForm.setBed(bed);
        admissionForm.setAdditionalInfo("Valid admission information");
        return admissionForm;
    }
}
