package hms.pms.contracts.steps;

import hms.pms.contracts.testStubs.repositories.BedRepositoryStub;
import hms.pms.contracts.testStubs.repositories.RoomRepositoryStub;
import hms.pms.contracts.testStubs.repositories.WardRepositoryStub;
import hms.pms.domain.patient.entities.Patient;
import hms.pms.domain.patient.repositories.PatientRepository;
import hms.pms.domain.staff.entities.Staff;
import hms.pms.domain.staff.repositories.StaffRepository;
import hms.pms.domain.ward.entities.Bed;
import hms.pms.domain.ward.entities.Room;
import hms.pms.domain.ward.entities.Ward;
import hms.pms.domain.ward.repositories.BedRepository;
import hms.pms.domain.ward.repositories.RoomRepository;
import hms.pms.domain.ward.repositories.WardRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class StepUtils {
    public static Staff createChargeNurseAccount(StaffRepository staffRepository) {
        Staff staff = new Staff(UUID.randomUUID(),
                "John", "Doe",
                "pass", "johnDoe@gmail.com");
        staff.setRole("CHARGE_NURSE");

        staffRepository.save(staff);
        return staff;
    }

    public static Patient createPatient(PatientRepository patientRepository) {
        Patient patient = new Patient("123456", "John", "Doe",
                "123-456-7890", new Date(), 'M', "Single",
                UUID.randomUUID(), new ArrayList<>(), "Nurse-123");

        patientRepository.save(patient);
        return patient;
    }

    public static Ward createWard(RoomRepository roomRepository, BedRepository bedRepository,
                                  WardRepository wardRepository) {

        UUID[] roomNbrs = new UUID[4]; // Array to store room numbers
        int occupiedBeds = 15;
        for (int i = 0; i < roomNbrs.length; i++) {
            Bed[] beds = new Bed[5];// Assuming each room has 5 beds
            UUID[] bedNbrs = new UUID[beds.length];

            for (int j = 0; j < beds.length; j++) {
                UUID bedNbr = UUID.randomUUID();
                beds[j] = new Bed(bedNbr);
                if (occupiedBeds-- > 0) beds[j].occupy();
                bedNbrs[j] = bedNbr;

                bedRepository.save(beds[j]); // Save each bed
            }

            UUID roomNbr = UUID.randomUUID();
            roomNbrs[i] = roomNbr;
            Room room = new Room(roomNbr, bedNbrs);

            roomRepository.save(room); // Save the room
        }

        Ward ward = new Ward(UUID.randomUUID(), "Cardiology",
                UUID.randomUUID(), "Building A - Floor 3", 20, occupiedBeds,
                1234, "incomplete", roomNbrs);

        wardRepository.save(ward);
        return ward;
    }

    public static Ward createFullWard(RoomRepositoryStub roomRepository, BedRepositoryStub bedRepository, WardRepository wardRepository) {
        UUID[] roomNbrs = new UUID[4]; // Array to store room numbers

        for (int i = 0; i < roomNbrs.length; i++) {
            Bed[] beds = new Bed[5]; // Assuming each room has 5 beds
            UUID[] bedNbrs = new UUID[beds.length];

            for (int j = 0; j < beds.length; j++) {
                UUID bedNbr = UUID.randomUUID();
                beds[j] = new Bed(bedNbr);
                bedNbrs[j] = bedNbr;
                beds[j].occupy();
                bedRepository.save(beds[j]); // Save each bed
            }

            UUID roomNbr = UUID.randomUUID();
            roomNbrs[i] = roomNbr;
            Room room = new Room(roomNbr, bedNbrs);

            roomRepository.save(room); // Save the room
        }

        Ward ward = new Ward(UUID.randomUUID(), "Cardiology",
                UUID.randomUUID(), "Building A - Floor 3", 20, 20,
                1234, "complete", roomNbrs);

        wardRepository.save(ward);
        return ward;
    }

}
