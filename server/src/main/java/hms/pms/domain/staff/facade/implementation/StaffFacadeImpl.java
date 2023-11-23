package hms.pms.domain.staff.facade.implementation;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.Application.services.DomainEventEmitter;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.events.StaffCreated;
import hms.pms.domain.staff.facade.StaffFacade;
import hms.pms.domain.staff.factories.StaffFactory;
import hms.pms.domain.staff.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class StaffFacadeImpl implements StaffFacade {

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
    public boolean createStaffAccount(StaffInfoCreateDTO staffInfoDTO) {
        Staff staff = staffRepository.find(staffInfoDTO.employeeNbr);
        if (staff != null) return false;

        staff = staffFactory.createStaffAccount(staffInfoDTO);
        staff.setRole(staffInfoDTO.getRole());

        staffRepository.save(staff);
        eventEmitter.emit(new StaffCreated(staff.getId(), new Date()));
        return true;
    }
}
