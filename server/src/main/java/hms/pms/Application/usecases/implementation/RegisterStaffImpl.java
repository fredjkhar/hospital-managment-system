package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.Application.usecases.RegisterStaff;
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
