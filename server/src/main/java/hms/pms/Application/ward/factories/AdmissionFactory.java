package hms.pms.Application.ward.factories;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;
import hms.pms.Application.ward.entities.Admission;

public interface AdmissionFactory {
    Admission createAdmission(PatientAdmissionCreateTDO admissionInfo);
}
