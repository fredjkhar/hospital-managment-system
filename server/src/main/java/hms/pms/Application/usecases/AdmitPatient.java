package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;

public interface AdmitPatient {
    Boolean admitPatient(PatientAdmissionCreateTDO patientFileAdmission, DivisionInfoCreateDTO divisionInfo);
}
