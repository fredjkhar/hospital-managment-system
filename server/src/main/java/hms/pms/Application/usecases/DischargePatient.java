package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.PatientDischargeCreateDTO;

import java.util.UUID;

public interface DischargePatient {
    void dischargePatient(UUID wardId, PatientDischargeCreateDTO patientDischargeInfo);
}
