package hms.pms.domain.ward.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

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
    private List<Admission> admissions;
    private List<Discharge> dischargeInfos;
    private Queue<AdmissionRequest> admissionRequests;
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
        this.dischargeInfos = new ArrayList<>();
        this.admissionRequests = new ArrayDeque<>();
        this.rooms = rooms;
    }

    public boolean admitPatient(Admission admission) {
        if (totalBeds == occupiedBeds) {
            return false;
        }
        admissions.add(admission);
        occupiedBeds++;
        updateWardStatus();
        return true;
    }

    public boolean admitPatientFromRequestList(AdmissionRequest admissionRequest) {
        if (totalBeds == occupiedBeds) {
            return false;
        }
        admissionRequests.remove(admissionRequest);
        occupiedBeds++;
        updateWardStatus();
        return true;
    }

    public boolean dischargePatient(Discharge discharge, Admission admission) {
        if (!admissions.contains(admission)) {
            return false;
        }
        dischargeInfos.add(discharge);
        admissions.remove(admission);
        occupiedBeds--;
        updateWardStatus();
        return true;
    }

    public Admission getAdmission(UUID patientId) {
        return admissions.stream()
                .filter(admission -> admission.getPatientId().equals(patientId))
                .findFirst()
                .orElse(null);
    }

    public AdmissionRequest getAdmissionRequest(UUID patientId) {
        return admissionRequests.stream()
                .filter(request -> request.getPatientId().equals(patientId))
                .findFirst()
                .orElse(null);
    }

    private void updateWardStatus() {
        status = occupiedBeds == totalBeds ? STATUS_COMPLETE : STATUS_INCOMPLETE;
    }
}