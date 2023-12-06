package hms.pms.infrastructure.configuration;

import hms.pms.adapters.services.implementation.application.DomainEventEmitterAdapter;
import hms.pms.application.services.DomainEventEmitter;
import hms.pms.application.usecases.*;
import hms.pms.application.usecases.implementation.*;
import hms.pms.domain.patient.facade.PatientFacade;
import hms.pms.domain.patient.facade.implementation.PatientFacadeImpl;
import hms.pms.domain.patient.factories.PatientFactory;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.prescription.facade.PrescriptionFacade;
import hms.pms.domain.prescription.facade.implementation.PrescriptionFacadeImpl;
import hms.pms.domain.prescription.factory.PrescriptionFactory;
import hms.pms.domain.prescription.repository.PrescriptionRepository;
import hms.pms.domain.staff.facade.StaffFacade;
import hms.pms.domain.staff.facade.implementation.StaffFacadeImpl;
import hms.pms.domain.staff.factories.StaffFactory;
import hms.pms.domain.staff.repositories.StaffRepository;
import hms.pms.domain.ward.facade.WardFacade;
import hms.pms.domain.ward.facade.implementation.WardFacadeImpl;
import hms.pms.domain.ward.factories.AdmissionFactory;
import hms.pms.domain.ward.factories.AdmissionRequestFactory;
import hms.pms.domain.ward.factories.DischargeFactory;
import hms.pms.domain.ward.repositories.*;
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

    @Bean
    public WardFacade wardFacade(WardRepository wardRepository, RoomRepository roomRepository,
                                 BedRepository bedRepository, PatientRepository patientRepository,
                                 AdmissionRepository admissionRepository, AdmissionRequestRepository admissionRequestRepository,
                                 AdmissionFactory admissionFactory, AdmissionRequestFactory admissionRequestFactory,
                                 DischargeFactory dischargeFactory, DomainEventEmitter eventEmitter) {
        return new WardFacadeImpl(wardRepository, roomRepository, bedRepository, patientRepository, admissionRepository, admissionRequestRepository,
                admissionFactory, admissionRequestFactory, dischargeFactory, eventEmitter);
    }

    @Bean
    public PrescriptionFacade prescriptionFacade(PrescriptionRepository prescriptionRepository,
                                                 PatientRepository patientRepository,
                                                 PrescriptionFactory prescriptionFactory,
                                                 DomainEventEmitter eventEmitter) {
        return new PrescriptionFacadeImpl(prescriptionRepository, patientRepository, prescriptionFactory, eventEmitter);
    }

    @Bean
    public PatientFacade patientFacade(PatientRepository patientRepository,
                                       PatientFactory patientFactory,
                                       DomainEventEmitter eventEmitter) {
        return new PatientFacadeImpl(patientRepository, patientFactory, eventEmitter);
    }

    @Bean
    StaffFacade staffFacade(StaffRepository staffRepository,
                            StaffFactory staffFactory,
                            DomainEventEmitter eventEmitter) {
        return new StaffFacadeImpl(staffRepository, staffFactory, eventEmitter);
    }

    @Bean
    public DomainEventEmitter domainEventEmitter() {
        return new DomainEventEmitterAdapter();
    }

}
