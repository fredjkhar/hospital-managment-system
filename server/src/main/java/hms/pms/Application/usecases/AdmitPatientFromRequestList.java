package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientAdmissionCreateTDO;
import hms.pms.Application.dtos.queries.WardInfoCreateDTO;

public interface AdmitPatientFromRequestList {
    Boolean admitPatientFromRequestList(PatientAdmissionCreateTDO patientFileAdmission, WardInfoCreateDTO wardInfo);
}
