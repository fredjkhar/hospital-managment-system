package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientFileAdmissionCreateTDO;

import java.util.UUID;

public interface AdmitPatientFromRequestList {
    Boolean admitPatientFromRequestList(PatientFileAdmissionCreateTDO patientFileAdmission, DivisionInfoCreateDTO divisionInfo);
}
