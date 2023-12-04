package hms.pms.domain.ward.repositories;

import hms.pms.domain.ward.entities.AdmissionRequest;

import java.util.UUID;

public interface AdmissionRequestRepository {

    AdmissionRequest find(UUID admissionRequestId);

    void save(AdmissionRequest admissionRequest);
}
