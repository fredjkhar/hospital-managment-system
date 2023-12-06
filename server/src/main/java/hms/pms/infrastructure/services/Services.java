package hms.pms.infrastructure.services;

import hms.pms.application.dtos.queries.AdmissionCreateDTO;
import hms.pms.application.dtos.queries.AdmissionRequestCreateDTO;
import hms.pms.application.dtos.queries.DischargeCreateDTO;
import hms.pms.application.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Services {
    private final AdmitPatient admitPatient;
    private final AdmitPatientFromRequestList admitPatientFromRequestList;
    private final ConsultPatientFile consultPatientFile;
    private final DischargePatient dischargePatient;
    private final PrescribeMedication prescribeMedication;
    private final RegisterPatient registerPatient;
    private final RegisterStaff registerStaff;
    private final RequestPatientAdmission requestPatientAdmission;
    private final UpdatePatientFile updatePatientFile;
    private final VisualizeWard visualizeWard;

    @Autowired
    public Services(AdmitPatient admitPatient, AdmitPatientFromRequestList admitPatientFromRequestList, ConsultPatientFile consultPatientFile, DischargePatient dischargePatient, PrescribeMedication prescribeMedication, RegisterPatient registerPatient, RegisterStaff registerStaff, RequestPatientAdmission requestPatientAdmission, UpdatePatientFile updatePatientFile, VisualizeWard visualizeWard) {
        this.admitPatient = admitPatient;
        this.admitPatientFromRequestList = admitPatientFromRequestList;
        this.consultPatientFile = consultPatientFile;
        this.dischargePatient = dischargePatient;
        this.prescribeMedication = prescribeMedication;
        this.registerPatient = registerPatient;
        this.registerStaff = registerStaff;
        this.requestPatientAdmission = requestPatientAdmission;
        this.updatePatientFile = updatePatientFile;
        this.visualizeWard = visualizeWard;
    }

    public Boolean admitPatient(UUID wardId, AdmissionCreateDTO admissionCreateDTO) {
        if (admissionCreateDTO == null || wardId == null) return false;
        admitPatient.admitPatient(wardId, admissionCreateDTO);
        return true;
    }

    public Boolean admitPatientFromRequestList(UUID wardId, AdmissionRequestCreateDTO admissionRequestCreateDTO) {
        if (admissionRequestCreateDTO == null) return false;
        admitPatientFromRequestList.admitPatientFromRequestList(wardId, admissionRequestCreateDTO);
        return true;
    }

    public Boolean consultPatientFile(UUID patientId) {
        if (patientId == null) return false;
        consultPatientFile.getPatientFile(patientId);
        return true;
    }

    public Boolean dischargePatient(UUID wardId, DischargeCreateDTO dischargeInfo) {
        if (wardId == null || dischargeInfo == null) return false;
        dischargePatient.dischargePatient(wardId, dischargeInfo);
        return true;
    }



}
