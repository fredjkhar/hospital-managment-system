package hms.pms.application.usecases.implementation;

import hms.pms.application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.application.usecases.RegisterStaff;
import hms.pms.domain.staff.facade.StaffFacade;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterStaffImpl implements RegisterStaff {

    private final StaffFacade staffFacade;

    @Autowired
    public RegisterStaffImpl(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @Override
    public void registerStaff(StaffInfoCreateDTO staffInfo) {
        staffFacade.createStaffAccount(staffInfo);
    }
}
