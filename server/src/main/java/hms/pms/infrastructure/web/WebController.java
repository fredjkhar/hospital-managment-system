package hms.pms.infrastructure.web;

import hms.pms.application.dtos.queries.*;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.infrastructure.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Boolean admitPatient(@RequestBody AdmissionCreateDTO admissionCreateDTO, @RequestParam(value = "wardId") UUID wardId) {
        return services.admitPatient(wardId, admissionCreateDTO);
    }

    @PostMapping("/admitPatientFromRequestList/{wardId}")
    @ResponseBody
    public Boolean admitPatientFromRequestList(@RequestBody AdmissionRequestCreateDTO admissionRequestCreateDTO, @RequestParam(value = "wardId") UUID wardId) {
        return services.admitPatientFromRequestList(wardId, admissionRequestCreateDTO);
    }

    @GetMapping("/consultPatientFile/{patientId}")
    @ResponseBody
    public Boolean consultPatientFile(@RequestParam(value = "patientId") UUID patientId) {
        return services.consultPatientFile(patientId);
    }

    @PostMapping("/dischargePatient/{wardId}")
    @ResponseBody
    public Boolean dischargePatient(@RequestBody DischargeCreateDTO dischargeInfo, @RequestParam(value = "wardId") UUID wardId) {
        return services.dischargePatient(wardId, dischargeInfo);
    }

    @PostMapping("/addPatientToRequestList")
    @ResponseBody
    public String addPatientToRequestList(@RequestBody AdmissionRequestCreateDTO admissionRequestCreateDTO) {
        return "Nice";
    }
    
    @PostMapping("/registerPatient")
    @ResponseBody
    public String registerPatient(@RequestBody PatientInfoCreateDTO patientInfoCreateDTO) {
        return "Nice";
    }

    @GetMapping("/getPatientsList")
    public String getPatientsList() {
        return "Nice";
    }

    @PostMapping("/updatePatientFile/{patientId}")
    @ResponseBody
    public String updatePatientFile(@RequestParam(value = "patientId") UUID patientId, @RequestBody PatientInfoCreateDTO patientInfoCreateDTO) {
        return "Nice";
    }

    @PostMapping("/updateStaff/{staffId}")
    @ResponseBody
    public String updateStaff(@RequestParam(value = "staffId") UUID staffId, @RequestBody StaffInfoCreateDTO staffInfoCreateDTO) {
        return "Nice";
    }

    @PostMapping("/registerStaff")
    @ResponseBody
    public String registerStaff(@RequestBody StaffInfoCreateDTO staffInfoCreateDTO) {
        return "Nice";
    }

    @GetMapping("/loginStaff/{staffId}")
    public String loginStaff() {
        return "Zween";
    }

    @GetMapping("/logoutStaff/{staffId}")
    public String logoutStaff() {
        return "Zween";
    }

    @GetMapping("/getWard/{wardId}")
    public String getWard(@RequestParam (value = "wardId") UUID wardId) {
        return "Zween";
    }
}
