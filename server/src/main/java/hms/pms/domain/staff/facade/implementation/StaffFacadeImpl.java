package hms.pms.domain.staff.facade.implementation;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.application.services.DomainEventEmitter;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.events.StaffCreated;
import hms.pms.domain.staff.events.StaffCreationFailed;
import hms.pms.domain.staff.events.StaffUpdateFailed;
import hms.pms.domain.staff.events.StaffUpdated;
import hms.pms.domain.staff.facade.StaffFacade;
import hms.pms.domain.staff.factories.StaffFactory;
import hms.pms.domain.staff.repositories.StaffRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class StaffFacadeImpl implements StaffFacade {

    private static final Logger logger = LogManager.getLogger(StaffFacadeImpl.class);

    private final StaffRepository staffRepository;
    private final StaffFactory staffFactory;
    private final DomainEventEmitter eventEmitter;

    @Autowired
    public StaffFacadeImpl(StaffRepository staffRepository, StaffFactory staffFactory, DomainEventEmitter eventEmitter) {
        this.staffRepository = staffRepository;
        this.staffFactory = staffFactory;
        this.eventEmitter = eventEmitter;
    }

    @Override
    public void createStaffAccount(StaffInfoCreateDTO staffInfoDTO) {
        Staff staff = staffRepository.find(staffInfoDTO.getEmployeeNbr());
        if (staff != null) {
            logger.warn("Failed to create staff account: Staff with employee number " + staffInfoDTO.getEmployeeNbr() + " already exists");
            eventEmitter.emit(new StaffCreationFailed(staffInfoDTO.getEmployeeNbr(), new Date(), "Staff already exists"));
            return;
        }

        staff = staffFactory.createStaffAccount(staffInfoDTO);
        staff.setRole(staffInfoDTO.getRole());

        staffRepository.save(staff);
        logger.info("Staff account created successfully: " + staff.getId());
        eventEmitter.emit(new StaffCreated(staff.getId(), new Date()));
    }

    @Override
    public void updateStaffAccount(UUID patientId, StaffInfoCreateDTO staffInfo) {
        Staff staff = staffRepository.find(patientId);
        if (staff == null) {
            logger.warn("Failed to update staff account: Staff with id " + patientId + " does not exist");
            eventEmitter.emit(new StaffUpdateFailed(patientId, new Date(), "Staff does not exist"));
            return;
        }

        staff.setFirstName(staffInfo.getFirstName());
        staff.setLastName(staffInfo.getLastName());
        staff.setEmail(staffInfo.getEmail());
        staff.setPassword(staffInfo.getPassword());
        staff.setRole(staffInfo.getRole());

        staffRepository.save(staff);
        logger.info("Staff account updated successfully: " + staff.getId());
        eventEmitter.emit(new StaffUpdated(staff.getId(), new Date()));
    }
}
