package hms.pms.infrastructure.configuration;

import hms.pms.application.usecases.*;
import hms.pms.application.usecases.implementation.*;
import hms.pms.domain.patient.facade.PatientFacade;
import hms.pms.domain.patient.factories.PatientFactory;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.prescription.facade.PrescriptionFacade;
import hms.pms.domain.staff.facade.StaffFacade;
import hms.pms.domain.staff.factories.StaffFactory;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.repositories.WardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public AdmitPatient admitPatientUseCase(PatientRepository patientRepository, WardRepository wardRepository, WardFacade wardFacade){
        return new AdmitPatientImpl(patientRepository, wardRepository, wardFacade);
    }

    @Bean
    public AdmitPatientFromRequestList admitPatientFromRequestListUseCase(PatientRepository patientRepository, WardRepository wardRepository, WardFacade wardFacade){
        return new AdmitPatientFromRequestListImpl(patientRepository, wardRepository, wardFacade);
    }

    @Bean
    public DischargePatient dischargePatientUseCase(PatientRepository patientRepository, WardRepository wardRepository, WardFacade wardFacade){
        return new DischargePatientImpl(patientRepository, wardRepository, wardFacade);
    }

    @Bean
    public PrescribeMedication prescribeMedicationUseCase(PatientRepository patientRepository, PrescriptionFacade prescriptionFacade){
        return new PrescribeMedicationImpl(patientRepository, prescriptionFacade);
    }

    @Bean
    public RegisterPatient registerPatientUseCase(PatientFacade patientFacade){
        return new RegisterPatientImpl(patientFacade);
    }

    @Bean
    public RegisterStaff registerStaffUseCase(StaffFacade staffFacade){
        return new RegisterStaffImpl(staffFacade);
    }

    @Bean
    public RequestPatientAdmission requestPatientAdmissionUseCase(WardRepository wardRepository, WardFacade wardFacade){
        return new RequestPatientAdmissionImpl(wardRepository, wardFacade);
    }

    @Bean
    public UpdatePatientFile updatePatientFileUseCase(PatientRepository patientRepository, PatientFacade patientFacade){
        return new UpdatePatientFileImpl(patientRepository, patientFacade);
    }


}
