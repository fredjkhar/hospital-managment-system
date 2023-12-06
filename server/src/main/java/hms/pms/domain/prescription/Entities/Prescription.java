package hms.pms.domain.prescription.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Prescription {
    private UUID prescriptionId;
    private String drugNumber;
    private String drugName;
    private int unitsByDay;
    private int numberOfAdminsPerDay;
    private AdministrationTime[] administrationTimes;
    private String methodOfAdministration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date finishDate;

    public Prescription(String drugNumber,
                        String drugName, AdministrationTime[] administrationTimes, int unitsByDay,
                        int numberOfAdminsPerDay, String methodOfAdministration,
                        Date startDate, Date finishDate) {
        this.prescriptionId = UUID.randomUUID();
        this.drugNumber = drugNumber;
        this.drugName = drugName;
        this.administrationTimes = administrationTimes;
        this.unitsByDay = unitsByDay;
        this.numberOfAdminsPerDay = numberOfAdminsPerDay;
        this.methodOfAdministration = methodOfAdministration;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public void update(Prescription updated) {
        this.drugNumber = updated.getDrugNumber();
        this.drugName = updated.getDrugName();
        this.unitsByDay = updated.getUnitsByDay();
        this.numberOfAdminsPerDay = updated.getNumberOfAdminsPerDay();
        this.methodOfAdministration = updated.getMethodOfAdministration();
        this.startDate = updated.getStartDate();
        this.finishDate = updated.getFinishDate();
        this.administrationTimes = updated.getAdministrationTimes();
    }
}
