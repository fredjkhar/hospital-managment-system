package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;
import java.util.UUID;


public interface AdmitPatient {
    Boolean admitPatient(PatientAdmissionCreateTDO patientFileAdmission, UUID wardId);
}
