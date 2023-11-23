package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateDTO;
import java.util.UUID;


public interface AdmitPatient {
    boolean admitPatient(UUID wardId, PatientAdmissionCreateDTO patientFileAdmission);
}
