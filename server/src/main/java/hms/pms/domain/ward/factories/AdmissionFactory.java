package hms.pms.domain.ward.factories;

import hms.pms.application.dtos.queries.PatientAdmissionCreateDTO;
import hms.pms.domain.ward.entities.Admission;

public interface AdmissionFactory {
    Admission createAdmission(PatientAdmissionCreateDTO admissionInfo);
}
