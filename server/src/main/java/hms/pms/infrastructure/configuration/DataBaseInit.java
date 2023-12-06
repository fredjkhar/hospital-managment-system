package hms.pms.infrastructure.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class DataBaseInit implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initWards();
        initStaff();
        initPatients();

        //TODO: Add some patients to wards
    }

    private void initWards() {
        // TODO: use your imagination to initialize the wards
    }

    private void initStaff() {
        // TODO: use your imagination to initialize the staff
    }

    private void initPatients() {
        // TODO: use your imagination to initialize the patients
    }
}
