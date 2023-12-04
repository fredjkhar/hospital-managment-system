package hms.pms.domain.ward.factories;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.domain.ward.entities.Admission;
import hms.pms.domain.ward.entities.AdmissionRequest;

import java.util.UUID;

public interface AdmissionFactory {
    Admission createAdmission(AdmissionCreateDTO admissionInfo);

    Admission createAdmission(AdmissionRequest admissionRequest, UUID roomNbr, UUID bedNbr, String insuranceNumber);
}
