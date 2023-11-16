package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientDischargeCreateDTO;
import hms.pms.Application.dtos.queries.WardInfoCreateDTO;


public interface DischargePatient {
    Boolean dischargePatient(PatientDischargeCreateDTO patientDischarge, WardInfoCreateDTO wardInfo);
}
