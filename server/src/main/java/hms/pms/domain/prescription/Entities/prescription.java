package hms.pms.domain.prescription.Entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class prescription {
    private final UUID id;
    private final String patientId;
    private final String drugName;
    private final float unitsByDay;
    private final Integer numberOfAdminsPerDay;
    private final List<String> administrationTimes;
    private final String methodOfAdministration;
    private final Date startDate;
    private final Date finishDate;

    public prescription(UUID id, String patientId, String drugName, float unitsByDay, Integer numberOfAdminsPerDay,
                        List<String> administrationTimes, String methodOfAdministration,
                        Date startDate, Date finishDate) {
        this.id = id;
        this.patientId = patientId;
        this.drugName = drugName;
        this.unitsByDay = unitsByDay;
        this.numberOfAdminsPerDay = numberOfAdminsPerDay;
        this.administrationTimes = administrationTimes;
        this.methodOfAdministration = methodOfAdministration;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public UUID getId() {
        return id;
    }

    public String getDin() {
        return patientId;
    }

    public String getName() {
        return drugName;
    }

    public float getUnitsPerDay() {
        return unitsByDay;
    }

    public Integer getAdminsPerDay() {
        return numberOfAdminsPerDay;
    }

    public List<String> getAdminTimes() {
        return administrationTimes;
    }

    public String getAdminUnits() {
        return methodOfAdministration;
    }

    public String getAdminMethod() {
        return methodOfAdministration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

}





