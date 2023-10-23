package hms.pms.Application.usecases;

import hms.pms.Application.dtos.queries.DivisionInfoCreateDTO;

import java.util.UUID;

public interface DischargePatient {
    Boolean dischargePatient(UUID patientId, DivisionInfoCreateDTO divisionInfo);
}
