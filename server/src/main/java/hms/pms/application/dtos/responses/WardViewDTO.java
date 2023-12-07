package hms.pms.application.dtos.responses;

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
    private List<UUID> admissions;
    private List<UUID> dischargeInformation;
    private List<UUID> admissionRequests;
    private UUID[] rooms;
}
