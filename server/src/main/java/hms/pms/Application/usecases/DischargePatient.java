package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;
import hms.pms.Application.dtos.queries.PatientDischargeCreateDTO;

import java.util.UUID;

public interface DischargePatient {
    boolean dischargePatient(UUID wardId, PatientDischargeCreateDTO patientDischargeInfo);
}
