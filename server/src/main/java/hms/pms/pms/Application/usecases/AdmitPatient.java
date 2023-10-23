package hms.pms.pms.Application.usecases;

import hms.pms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.pms.Application.dtos.queries.PatientFileAdmissionCreateTDO;

public interface AdmitPatient {
    Boolean admitPatient(PatientFileAdmissionCreateTDO patientFileAdmission, DivisionInfoCreateDTO divisionInfo);
}
