package hms.pms.application.dtos.responses;

import hms.pms.domain.ward.entities.Admission;
import hms.pms.domain.ward.entities.AdmissionRequest;
import hms.pms.domain.ward.entities.Discharge;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class WardViewDTO {
    private String wardName;
    private UUID chargeNurseId;
    private String location;
    private int totalBeds;
    private int occupiedBeds;
    private int extensionNumber;
    private String status;
    private List<Admission> admissions;
    private List<Discharge> dischargeInformation;
    private List<AdmissionRequest> admissionRequests;
    private UUID[] rooms;
}
