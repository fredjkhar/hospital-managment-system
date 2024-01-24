package hms.pms.infrastructure.services;

import hms.pms.application.dtos.queries.*;
import hms.pms.application.dtos.responses.PatientFileViewDTO;
import hms.pms.application.dtos.responses.WardViewDTO;
import hms.pms.application.dtos.responses.converters.PatientFileViewConverter;
import hms.pms.application.usecases.*;
import hms.pms.application.usecases.implementation.AdmitPatientImpl;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.facade.PatientFacade;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.staff.facade.StaffFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class Services {
    private static final Logger logger = LogManager.getLogger(AdmitPatientImpl.class);

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
    private final StaffFacade staffFacade;
    private final PatientFacade patientFacade;
    private final PatientRepository patientRepository;

    private final PatientFileViewConverter patientFileViewConverter = Mappers.getMapper(PatientFileViewConverter.class);



    @Autowired
    public Services(AdmitPatient admitPatient, AdmitPatientFromRequestList admitPatientFromRequestList,
                    ConsultPatientFile consultPatientFile, DischargePatient dischargePatient,
                    PrescribeMedication prescribeMedication, RegisterPatient registerPatient,
                    RegisterStaff registerStaff, RequestPatientAdmission requestPatientAdmission,
                    UpdatePatientFile updatePatientFile, VisualizeWard visualizeWard,
                    StaffFacade staffFacade, PatientFacade patientFacade,
                    PatientRepository patientRepository) {
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
        this.staffFacade = staffFacade;
        this.patientFacade = patientFacade;
        this.patientRepository = patientRepository;
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

    public PatientFileViewDTO consultPatientFile(UUID patientId) {
        if (patientId == null) return null;
        return consultPatientFile.getPatientFile(patientId);
    }

    public Boolean dischargePatient(UUID wardId, DischargeCreateDTO dischargeInfo) {
        if (wardId == null || dischargeInfo == null) return false;
        dischargePatient.dischargePatient(wardId, dischargeInfo);
        return true;
    }

    public Boolean prescribeMedication(UUID patientId, PrescriptionCreateDTO prescriptionCreateDTO) {
        if (patientId == null || prescriptionCreateDTO == null) return false;
        prescribeMedication.prescribeMedication(patientId, prescriptionCreateDTO);
        return true;
    }

    public Boolean registerPatient(PatientInfoCreateDTO patientInfoCreateDTO) {
        if (patientInfoCreateDTO == null) return false;
        registerPatient.registerPatient(patientInfoCreateDTO);
        return true;
    }

    public Boolean registerStaff(StaffInfoCreateDTO staffInfoCreateDTO) {
        if (staffInfoCreateDTO == null) return false;
        registerStaff.registerStaff(staffInfoCreateDTO);
        return true;
    }

    public Boolean requestPatientAdmission(AdmissionRequestCreateDTO admissionRequestCreateDTO, UUID wardId) {
        if (admissionRequestCreateDTO == null || wardId == null) return false;
        requestPatientAdmission.requestPatientAdmission(admissionRequestCreateDTO, wardId);
        return true;
    }

    public Boolean updatePatientFile(UUID patientId, PatientInfoCreateDTO patientInfoCreateDTO) {
        if (patientInfoCreateDTO == null) return false;
        updatePatientFile.updatePatientFile(patientId, patientInfoCreateDTO);
        return true;
    }

    public WardViewDTO visualizeWard(UUID wardId) {
        if (wardId == null) return null;
        return visualizeWard.getWardView(wardId);
    }

    public Boolean updateStaff(UUID staffId, StaffInfoCreateDTO staffInfoCreateDTO) {
        if (staffInfoCreateDTO == null) return false;
        staffFacade.updateStaffAccount(staffId, staffInfoCreateDTO);
        return true;
    }

    public List<PatientFileViewDTO> getPatientsList() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientFileViewDTO> patientFileViewDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientFileViewDTOS.add(patientFileViewConverter.toView(patient,
                    patient.getAddress(), patient.getNextOfKin(), patient.getPrescriptions()));
        }
        return patientFileViewDTOS;
    }

}
