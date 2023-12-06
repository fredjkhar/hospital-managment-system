package hms.pms.domain.ward.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Ward {
    private static final String STATUS_COMPLETE = "complete";
    private static final String STATUS_INCOMPLETE = "incomplete";

    private UUID wardId;
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

    public Ward(UUID wardId, String wardName, UUID chargeNurseId, String location,
                int totalBeds, int occupiedBeds, int extensionNumber, String status, UUID[] rooms) {
        this.wardId = wardId;
        this.wardName = wardName;
        this.chargeNurseId = chargeNurseId;
        this.location = location;
        this.totalBeds = totalBeds;
        this.occupiedBeds = occupiedBeds;
        this.extensionNumber = extensionNumber;
        this.status = status;
        this.admissions = new ArrayList<>();
        this.dischargeInformation = new ArrayList<>();
        this.admissionRequests = new ArrayList<>();
        this.rooms = rooms;
    }

    public boolean admitPatient(UUID admissionId) {
        if (totalBeds == occupiedBeds) {
            return false;
        }
        admissions.add(admissionId);
        occupiedBeds++;
        updateWardStatus();
        return true;
    }

    public boolean removePatientFromRequestList(UUID admissionRequestId) {
        if (totalBeds == occupiedBeds || !admissionRequests.contains(admissionRequestId)) {
            return false;
        }
        admissionRequests.remove(admissionRequestId);
        occupiedBeds++;
        updateWardStatus();
        return true;
    }

    public boolean dischargePatient(UUID dischargeId, UUID admissionId) {
        if (!admissions.contains(admissionId) || dischargeInformation.contains(dischargeId)) {
            return false;
        }
        dischargeInformation.add(dischargeId);
        admissions.remove(admissionId);
        occupiedBeds--;
        updateWardStatus();
        return true;
    }

    public UUID getAdmission(UUID patientId) {
        if (admissions.contains(patientId)) {
            return patientId;
        }
        return null;
    }

    public UUID getAdmissionRequest(UUID patientId) {
        if (admissionRequests.contains(patientId)) {
            return patientId;
        }
        return null;
    }

    private void updateWardStatus() {
        status = occupiedBeds == totalBeds ? STATUS_COMPLETE : STATUS_INCOMPLETE;
    }
}
