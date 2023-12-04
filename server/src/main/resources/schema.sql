-- CREATE TABLE IF NOT EXISTS ward (
--     divisionIdentifier varchar(255) not null,
--     divisionName varchar(255) not null,
--     chargeNurseName VARCHAR(255),
--     chargeNurseTelephoneExtension VARCHAR(20),
--     chargeNurseBipperExtension VARCHAR(20),
--     location varchar(255),
--     totalNumberOfBeds int,
--     currentNumberOfBeds int,
--     telephoneExtensionNumber VARCHAR(20),
--     statusOfDivision boolean not null,
--     primary key (divisionIdentifier)
--     );
--
-- CREATE TABLE IF NOT EXISTS patient (
--     insuranceNumber VARCHAR(255),
--     firstName VARCHAR(255),
--     lastName VARCHAR(255),
--     addressInfo_street VARCHAR(255),
--     addressInfo_city VARCHAR(255),
--     addressInfo_state VARCHAR(255),
--     addressInfo_zipCode VARCHAR(20),
--     phoneNumber VARCHAR(20),
--     dateOfBirth DATE,
--     gender VARCHAR(10),
--     maritalStatus VARCHAR(20),
--     externalDoctorId VARCHAR(255),
--     nextOfKinInfo_name VARCHAR(255),
--     nextOfKinInfo_phoneNumber VARCHAR(20),
--     primaryChargeNurseId VARCHAR(255),
--     primary key (insuranceNumber)
--     );
--
-- CREATE TABLE IF NOT EXISTS prescription (
--     drugNumber VARCHAR(255),
--     drugName VARCHAR(255),
--     unitsByDay INT,
--     numberOfAdminsPerDay INT,
--     methodOfAdministration VARCHAR(50),
--     startDate DATE,
--     finishDate DATE,
--     primary key (drugNumber)
--     );
--
--
-- CREATE TABLE IF NOT EXISTS staff (
--     employeeNbr UUID,
-- --     will probably have to enable password hashing or something similar for security
--     password VARCHAR(255),
--     firstName VARCHAR(255),
--     lastName VARCHAR(255),
--     role VARCHAR(50),
--     email VARCHAR(255) UNIQUE,
--     primary key (employeeNbr)
--     );
--
-- CREATE TABLE IF NOT EXISTS staff (
--     roomNbr UUID,
--     --     will probably have to enable password hashing or something similar for security
--     password VARCHAR(255),
--     firstName VARCHAR(255),
--     lastName VARCHAR(255),
--     role VARCHAR(50),
--     email VARCHAR(255) UNIQUE,
--     primary key (employeeNbr)
-- );

CREATE TABLE IF NOT EXISTS administration_time (
                                     id UUID PRIMARY KEY,
                                     timeOfDay VARCHAR(255) NOT NULL,
                                     unitsAdministered INT NOT NULL
);

CREATE TABLE IF NOT EXISTS admission_request (
                                   id UUID PRIMARY KEY,
                                   patientId UUID NOT NULL,
                                   rationaleForRequest VARCHAR(128) NOT NULL,
                                   priorityAssessment INT NOT NULL,
                                   localDoctorId UUID NOT NULL,
                                   ward_id UUID,
                                   FOREIGN KEY (ward_id) REFERENCES Ward(wardId)
);

CREATE TABLE IF NOT EXISTS bed (
                     bedNbr UUID PRIMARY KEY,
                     status VARCHAR(255) NOT NULL,
                     room_nbr UUID,
                     FOREIGN KEY (room_nbr) REFERENCES Room(roomNbr)
);

CREATE TABLE IF NOT EXISTS discharge (
                           id UUID PRIMARY KEY,
                           patientId UUID NOT NULL,
                           dischargeSummary VARCHAR(128) NOT NULL,
                           ward_id UUID,
                           FOREIGN KEY (ward_id) REFERENCES Ward(wardId)
);

CREATE TABLE IF NOT EXISTS patients (
                          patientId UUID PRIMARY KEY,
                          insuranceNumber VARCHAR(255) NOT NULL,
                          firstName VARCHAR(255) NOT NULL,
                          lastName VARCHAR(255) NOT NULL,
                          phoneNumber VARCHAR(20) NOT NULL,
                          dateOfBirth DATE NOT NULL,
                          gender CHAR(1) NOT NULL,
                          maritalStatus VARCHAR(20) NOT NULL,
                          externalDoctorId UUID,
                          primaryChargeNurseId VARCHAR(255),
                          address_street VARCHAR(255),
                          address_city VARCHAR(255),
                          address_state VARCHAR(255),
                          address_zipCode VARCHAR(20),
                          nextOfKin_name VARCHAR(255),
                          nextOfKin_phoneNumber VARCHAR(20),
                          nextOfKin_relationship VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS prescription (
                              prescriptionId UUID PRIMARY KEY,
                              drugNumber VARCHAR(255) NOT NULL,
                              drugName VARCHAR(255) NOT NULL,
                              unitsByDay INT NOT NULL,
                              numberOfAdminsPerDay INT NOT NULL,
                              methodOfAdministration VARCHAR(50) NOT NULL,
                              startDate DATE,
                              finishDate DATE,
                              patient_id UUID,
                              FOREIGN KEY (patient_id) REFERENCES patients(patientId)
);

CREATE TABLE IF NOT EXISTS room(
                      roomNbr UUID PRIMARY KEY,
                      status VARCHAR(255) NOT NULL,
                      occupiedBeds INT NOT NULL,
                      ward_id UUID,
                      FOREIGN KEY (ward_id) REFERENCES Ward(wardId)
);

CREATE TABLE IF NOT EXISTS staff (
                       id UUID PRIMARY KEY,
                       employeeNbr UUID NOT NULL,
                       firstName VARCHAR(255) NOT NULL,
                       lastName VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ward (
                      wardId UUID PRIMARY KEY,
                      wardName VARCHAR(255) NOT NULL,
                      chargeNurseId UUID,
                      location VARCHAR(255) NOT NULL,
                      totalBeds INT NOT NULL,
                      occupiedBeds INT NOT NULL,
                      extensionNumber INT NOT NULL,
                      status VARCHAR(255) NOT NULL
);

