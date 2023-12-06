package hms.pms.infrastructure.web;

import hms.pms.application.dtos.queries.*;
import hms.pms.application.dtos.responses.PatientFileViewDTO;
import hms.pms.application.dtos.responses.WardViewDTO;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.infrastructure.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class WebController {

    private final Services services;

    @Autowired
    public WebController(Services services) {
        this.services = services;
    }

    @PostMapping("/admitPatient/{wardId}")
    @ResponseBody
    public Boolean admitPatient(@RequestBody AdmissionCreateDTO admissionCreateDTO, @PathVariable UUID wardId) {
        return services.admitPatient(wardId, admissionCreateDTO);
    }


    @PostMapping("/admitPatientFromRequestList/{wardId}")
    @ResponseBody
    public Boolean admitPatientFromRequestList(@RequestBody AdmissionRequestCreateDTO admissionRequestCreateDTO, @PathVariable UUID wardId) {
        return services.admitPatientFromRequestList(wardId, admissionRequestCreateDTO);
    }

    @GetMapping("/consultPatientFile/{patientId}")
    public PatientFileViewDTO consultPatientFile(@PathVariable UUID patientId) {
        return services.consultPatientFile(patientId);
    }

    @PostMapping("/dischargePatient/{wardId}")
    @ResponseBody
    public Boolean dischargePatient(@RequestBody DischargeCreateDTO dischargeInfo, @PathVariable UUID wardId) {
        return services.dischargePatient(wardId, dischargeInfo);
    }

    @PostMapping("/prescribeMedication/{patientId}")
    @ResponseBody
    public Boolean prescribeMedication(@RequestBody PrescriptionCreateDTO prescriptionCreateDTO, @PathVariable UUID patientId) {
        return services.prescribeMedication(patientId, prescriptionCreateDTO);
    }

    @PostMapping("/registerPatient")
    @ResponseBody
    public Boolean registerPatient(@RequestBody PatientInfoCreateDTO patientInfoCreateDTO) {
        return services.registerPatient(patientInfoCreateDTO);
    }

    @PostMapping("/registerStaff")
    @ResponseBody
    public Boolean registerStaff(@RequestBody StaffInfoCreateDTO staffInfoCreateDTO) {
        return services.registerStaff(staffInfoCreateDTO);
    }

    @PostMapping("/requestPatientAdmission/{wardId}")
    @ResponseBody
    public Boolean requestPatientAdmission(@RequestBody AdmissionRequestCreateDTO admissionRequestCreateDTO, @PathVariable UUID wardId) {
        return services.requestPatientAdmission(admissionRequestCreateDTO, wardId);
    }

    @PostMapping("/updatePatientFile/{patientId}")
    @ResponseBody
    public Boolean updatePatientFile(@RequestBody PatientInfoCreateDTO patientInfoCreateDTO, @PathVariable UUID patientId) {
        return services.updatePatientFile(patientId, patientInfoCreateDTO);
    }

    @GetMapping("/getWard/{wardId}")
    public WardViewDTO visualizeWard(@RequestParam(value = "wardId") UUID wardId) {
        return services.visualizeWard(wardId);
    }

    @PostMapping("/updateStaff/{staffId}")
    @ResponseBody
    public Boolean updateStaff(@PathVariable UUID staffId, @RequestBody StaffInfoCreateDTO staffInfoCreateDTO) {
        return services.updateStaff(staffId, staffInfoCreateDTO);
    }

    @GetMapping("/getPatientsList")
    public List<PatientFileViewDTO> getPatientsList() {
        return services.getPatientsList();
    }

    @GetMapping("/loginStaff/{staffId}")
    public String loginStaff(@PathVariable UUID staffId) {
        //TODO: Aymane
        return "Zween";
    }

    @GetMapping("/logoutStaff/{staffId}")
    public String logoutStaff(@PathVariable UUID staffId) {
        //TODO: Aymane
        return "Zween";
    }
}
