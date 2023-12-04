package hms.pms.adapters.repositories.converters;

import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.entities.StaffRole;
import hms.pms.infrastructure.jpa.entities.staff.StaffJpaEntity;
import hms.pms.infrastructure.jpa.entities.staff.StaffRoleJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffJpaConverter {
    StaffJpaEntity toJpa(Staff staff);

    Staff toModel(StaffJpaEntity staffJpaEntity);

    StaffRoleJpaEntity staffRoleToJpa(StaffRole staff);

    StaffRole staffRoleToModel(StaffRoleJpaEntity staffJpaEntity);
}
