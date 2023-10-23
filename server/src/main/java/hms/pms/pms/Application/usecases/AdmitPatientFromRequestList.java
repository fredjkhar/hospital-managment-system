package hms.pms.pms.Application.usecases;

import hms.pms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.pms.Application.dtos.queries.PatientFileAdmissionCreateTDO;

public interface AdmitPatientFromRequestList {
    Boolean admitPatientFromRequestList(PatientFileAdmissionCreateTDO patientFileAdmission, DivisionInfoCreateDTO divisionInfo);
}
