package hms.pms.application.usecases;

import hms.pms.application.dtos.queries.PatientDischargeCreateDTO;

import java.util.UUID;

public interface DischargePatient {
    void dischargePatient(UUID wardId, PatientDischargeCreateDTO patientDischargeInfo);
}
