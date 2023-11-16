package hms.pms.contracts.testStubs.factories;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;
import hms.pms.domain.division.entities.Bed;
import hms.pms.domain.division.entities.Room;
import hms.pms.domain.division.entities.Ward;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.patient.factories.AdmissionFormFactory;

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
