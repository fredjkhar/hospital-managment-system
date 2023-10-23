package hms.pms.pms.Application.dtos.queries;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

public class PrescriptionCreateDTO {
    private String drugNumber;
    private String drugName;
    private int unitsByDay;
    private int numberOfAdminsPerDay;
    private List<AdministrationTime> administrationTimes;
    private String methodOfAdministration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date finishDate;

    private static class AdministrationTime {
        private String timeOfDay;
        private int unitsAdministered;
    }
}

