package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;

public interface AdmitPatientFromRequestList {
    Boolean admitPatientFromRequestList(PatientAdmissionCreateTDO patientFileAdmission, DivisionInfoCreateDTO divisionInfo);
}
