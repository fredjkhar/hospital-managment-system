package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientDischargeCreateDTO;

import java.util.UUID;

public interface DischargePatient {
    Boolean dischargePatient(PatientDischargeCreateDTO patientDischarge, DivisionInfoCreateDTO divisionInfo);
}
