package hms.pms.infrastructure.web;

import hms.pms.application.dtos.queries.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class WebController {

    @PostMapping("/admitPatient")
    @ResponseBody
    public String admitPatient(@RequestBody AdmissionCreateDTO admissionCreateDTO) {
        return "Nice";
    }

    @PostMapping("/dischargePatient")
    @ResponseBody
    public String dischargePatient(@RequestBody DischargeCreateDTO dischargeCreateDTO) {
        return "Nice";
    }

    @PostMapping("/addPatientToRequestList")
    @ResponseBody
    public String addPatientToRequestList(@RequestBody AdmissionRequestCreateDTO admissionRequestCreateDTO) {
        return "Nice";
    }

    @GetMapping("/consultPatientFile/{patientId}")
    public String consultPatientFile(@RequestParam(value = "patientId") UUID patientId) {
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
