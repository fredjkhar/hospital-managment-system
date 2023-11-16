package hms.pms.Application.ward.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

public class Ward {
    public static final String STATUS_COMPLETE = "complete";
    public static final String STATUS_INCOMPLETE = "incomplete";

    UUID wardId;
    String wardName;
    UUID chargeNurseId;
    String location;
    int totalBeds;
    int occupiedBeds;
    int extensionNumber;
    String status;
    List<UUID> admissions;
    Queue<UUID> admissionRequests;

    public Ward(UUID id, String wardName, UUID chargeNurseId, String location, int totalBeds, int occupiedBeds, int extensionNumber) {
        this.wardId = (id == null ? UUID.randomUUID() : id);
        this.wardName = wardName;
        this.chargeNurseId = chargeNurseId;
        this.location = location;
        this.totalBeds = totalBeds;
        this.occupiedBeds = occupiedBeds;
        this.extensionNumber = extensionNumber;
        this.status = STATUS_INCOMPLETE;
        this.admissions = new LinkedList<UUID>();
        this.admissionRequests = new LinkedList<UUID>();
    }

    public void admittedPatient() {
        occupiedBeds++;
        if (occupiedBeds == totalBeds) {
            status = STATUS_COMPLETE;
        }
    }

    public void dischargedPatient() {
        occupiedBeds--;
        status = STATUS_INCOMPLETE;
    }

    public String getStatus() {
        return status;
    }
}
