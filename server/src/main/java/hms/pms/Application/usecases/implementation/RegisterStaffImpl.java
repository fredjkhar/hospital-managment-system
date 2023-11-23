package hms.pms.Application.usecases.implementation;

import hms.pms.Application.dtos.queries.StaffInfoCreateDTO;
import hms.pms.Application.usecases.RegisterStaff;
import hms.pms.domain.staff.facade.StaffFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RegisterStaffImpl implements RegisterStaff {

    private final StaffFacade staffFacade;

    @Autowired
    public RegisterStaffImpl(StaffFacade staffFacade) {
        this.staffFacade = staffFacade;
    }

    @Override
    public boolean registerStaff(StaffInfoCreateDTO staffInfo) {
        return staffFacade.createStaffAccount(staffInfo);
    }
}
