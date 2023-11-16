package hms.pms.domain.prescription.Entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class administration {
    private String timeOfDay;
    private int unitsAdministered;
    private static class AdministrationTime {
        private String timeOfDay;
        private int unitsAdministered;
    }

    public administration(String timeOfDay, int unitsAdministered){
        this.timeOfDay = timeOfDay;
        this.unitsAdministered = unitsAdministered;
    }

    public String getTimeOfDay(){
        return timeOfDay;
    }
    public int getUnitsAdministered(){
        return unitsAdministered;
    }
}





