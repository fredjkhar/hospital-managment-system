package hms.pms.domain.staff.facade.implementation;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.Application.services.DomainEventEmitter;
import hms.pms.domain.staff.entities.staff.Staff;
import hms.pms.domain.staff.events.StaffCreatedEvent;
import hms.pms.domain.staff.events.StaffUpdatedEvent;
import hms.pms.domain.staff.facade.StaffFacade;
import hms.pms.domain.staff.factories.StaffFactory;
import hms.pms.domain.staff.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class StaffFacadeImpl implements StaffFacade {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private final DomainEventEmitter eventEmitter;
    private final StaffRepository staffRepository;
    private final StaffFactory staffFactory;

    @Autowired
    public StaffFacadeImpl(StaffRepository staffRepository, StaffFactory staffFactory, DomainEventEmitter eventEmitter) {
        this.staffRepository = staffRepository;
        this.staffFactory = staffFactory;
        this.eventEmitter = eventEmitter;
    }
    
    @Override
    public UUID createStaffAccount(StaffInfoCreateDTO staffInfoDTO) {
        Staff staff = staffRepository.find(staffInfoDTO.employeeNbr);
        if (staff != null) {
            return null;
        }
        staff = staffFactory.createStaffAccount(staffInfoDTO);
        eventEmitter.emit(new StaffCreatedEvent(staff.getId(), new Date()));
        return staff.getId();
    }

    @Override
    public boolean updateStaffAccount(String staffId, StaffInfoCreateDTO staffInfoDTO) {
        if (!isValidStaffInfoDTO(staffInfoDTO) ) {
            return false;
        }
        Staff staff = staffRepository.find(staffId);
        if (staff == null) {
            return false;
        }
        Staff _staff = staffFactory.createStaffAccount(staffInfoDTO);
        staff.update(_staff);
        staffRepository.save(staff);
        eventEmitter.emit(new StaffUpdatedEvent(staff.getId(), new Date()));
        return true;
    }

    private boolean isValidStaffInfoDTO(StaffInfoCreateDTO staffInfoDTO) {
        if (staffInfoDTO == null) {
            return false;
        }
        if (isNullOrEmpty(staffInfoDTO.employeeNbr) || isNullOrEmpty(staffInfoDTO.password) ||
                isNullOrEmpty(staffInfoDTO.password) || isNullOrEmpty(staffInfoDTO.firstName) ||
                isNullOrEmpty(staffInfoDTO.lastName) || isNullOrEmpty(String.valueOf(staffInfoDTO.role)) ||
                isNullOrEmpty(staffInfoDTO.email)) {
            return false;
        }
        return isValidEmail(staffInfoDTO.email);
    }

    private boolean isValidEmail(String email) {
        return !isNullOrEmpty(email) && email.matches(EMAIL_REGEX);
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
