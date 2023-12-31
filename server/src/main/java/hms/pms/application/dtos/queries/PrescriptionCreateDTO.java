package hms.pms.application.dtos.queries;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PrescriptionCreateDTO {

    private String drugNumber;
    private String drugName;
    private int unitsByDay;
    private int numberOfAdminsPerDay;
    private List<AdministrationTimeCreateDTO> administrationTimes;
    private String methodOfAdministration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date finishDate;

    public PrescriptionCreateDTO(String drugNumber, String drugName,
                                 int unitsByDay, int numberOfAdminsPerDay,
                                 String methodOfAdministration, Date startDate, Date finishDate) {
        this.drugNumber = drugNumber;
        this.drugName = drugName;
        this.unitsByDay = unitsByDay;
        this.numberOfAdminsPerDay = numberOfAdminsPerDay;
        this.methodOfAdministration = methodOfAdministration;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}

