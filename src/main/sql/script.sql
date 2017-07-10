
DROP DATABASE IF EXISTS `familydoctor`;
CREATE SCHEMA IF NOT EXISTS `familydoctor` DEFAULT CHARACTER SET latin1 ;
USE `familydoctor` ;

CREATE TABLE IF NOT EXISTS `familydoctor`.`Address` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CITY` VARCHAR(255) NULL DEFAULT NULL,
  `STATE` VARCHAR(255) NULL DEFAULT NULL,
  `STREET` VARCHAR(255) NULL DEFAULT NULL,
  `ZIPCODE` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `familydoctor`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `familydoctor`.`User` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` VARCHAR(255) NOT NULL,
  `ENABLED` BIT(1) NOT NULL,
  `PASSWORD` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `UK_gmrrm359qu7ogusdu9r2qr637` (`EMAIL` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `familydoctor`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `familydoctor`.`Admin` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE_OF_BIRTH` DATETIME NOT NULL,
  `FIRST_NAME` VARCHAR(255) NOT NULL,
  `GENDER` VARCHAR(255) NOT NULL,
  `LAST_NAME` VARCHAR(255) NOT NULL,
  `PHONE` VARCHAR(255) NOT NULL,
  `STAFF_NUMBER` VARCHAR(255) NOT NULL,
  `ADDRESS_ID` INT(11) NULL DEFAULT NULL,
  `USER_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_2pbu7gm8y7213eq3g0n5n0ynm` (`ADDRESS_ID` ASC),
  INDEX `FK_82o6xd2ts1wxekwyt01kw04kp` (`USER_ID` ASC),
  CONSTRAINT `FK_2pbu7gm8y7213eq3g0n5n0ynm`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `familydoctor`.`Address` (`ID`),
  CONSTRAINT `FK_82o6xd2ts1wxekwyt01kw04kp`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `familydoctor`.`User` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `familydoctor`.`Doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `familydoctor`.`Doctor` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE_OF_BIRTH` DATETIME NOT NULL,
  `FIRST_NAME` VARCHAR(255) NOT NULL,
  `GENDER` VARCHAR(255) NOT NULL,
  `LAST_NAME` VARCHAR(255) NOT NULL,
  `PHONE` VARCHAR(255) NOT NULL,
  `LICENSE_NUMBER` VARCHAR(255) NOT NULL,
  `SPECIALIZATION` VARCHAR(255) NOT NULL,
  `ADDRESS_ID` INT(11) NULL DEFAULT NULL,
  `USER_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_8smkhpbdcego8pxx3pxra742w` (`ADDRESS_ID` ASC),
  INDEX `FK_3wg7wl7952da7irghhb8884pi` (`USER_ID` ASC),
  CONSTRAINT `FK_3wg7wl7952da7irghhb8884pi`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `familydoctor`.`User` (`ID`),
  CONSTRAINT `FK_8smkhpbdcego8pxx3pxra742w`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `familydoctor`.`Address` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `familydoctor`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `familydoctor`.`Invoice` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `AMOUNT` DECIMAL(8,2) NULL DEFAULT NULL,
  `CCARD_4DIGITS` VARCHAR(255) NULL DEFAULT NULL,
  `DATE_CREATED` DATETIME NULL DEFAULT NULL,
  `DATE_PAID` DATETIME NULL DEFAULT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `familydoctor`.`Patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `familydoctor`.`Patient` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE_OF_BIRTH` DATETIME NOT NULL,
  `FIRST_NAME` VARCHAR(255) NOT NULL,
  `GENDER` VARCHAR(255) NOT NULL,
  `LAST_NAME` VARCHAR(255) NOT NULL,
  `PHONE` VARCHAR(255) NOT NULL,
  `SSN` VARCHAR(4) NOT NULL,
  `ADDRESS_ID` INT(11) NULL DEFAULT NULL,
  `USER_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

    
ALTER TABLE  `Patient`
    ADD CONSTRAINT `FK_80te39bnl2kdhljvvo506pv7d`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `Address` (`ID`)
    ON DELETE CASCADE ON UPDATE CASCADE;
    ALTER TABLE  `Patient`
    ADD CONSTRAINT `FK_pjmre4cud9y1f3ioigns2la62`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `User` (`ID`)
    ON DELETE CASCADE ON UPDATE CASCADE;



-- -----------------------------------------------------
-- Table `familydoctor`.`Appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `familydoctor`.`Appointment` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE` DATETIME NOT NULL,
  `DESCRIPTION` VARCHAR(255) NOT NULL,
  `ROOM` VARCHAR(255) NULL DEFAULT NULL,
  `STATUS` VARCHAR(255) NOT NULL,
  `TIME` VARCHAR(10) NOT NULL,
  `DOCTOR_ID` INT(11) NULL DEFAULT NULL,
  `INVOICE_ID` INT(11) NULL DEFAULT NULL,
  `PATIENT_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

    
    ALTER TABLE  `Appointment`
    ADD CONSTRAINT `FK_73fujq610wionybldepbttf50`
    FOREIGN KEY (`DOCTOR_ID`)
    REFERENCES `Doctor` (`ID`)
    ON DELETE CASCADE ON UPDATE CASCADE;
	ALTER TABLE  `Appointment`
    ADD CONSTRAINT `FK_hjpll3t3cbtd6mx6hpud3uqn9`
    FOREIGN KEY (`INVOICE_ID`)
    REFERENCES `Invoice` (`ID`)
    ON DELETE CASCADE ON UPDATE CASCADE;
     ALTER TABLE  `Appointment`
    ADD CONSTRAINT `FK_r141ik4mmvg4bglt2sy4ne30v`
    FOREIGN KEY (`PATIENT_ID`)
    REFERENCES `Patient` (`ID`)
    ON DELETE CASCADE ON UPDATE CASCADE;
     
    
-- -----------------------------------------------------
-- Table `familydoctor`.`Authority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `familydoctor`.`Authority` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `AUTHORITY` VARCHAR(255) NOT NULL,
  `EMAIL` VARCHAR(255) NULL DEFAULT NULL,
  `AUTHORITY_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_604e4r6i7svo0uomgp4et774s` (`AUTHORITY_ID` ASC),
  CONSTRAINT `FK_604e4r6i7svo0uomgp4et774s`
    FOREIGN KEY (`AUTHORITY_ID`)
    REFERENCES `familydoctor`.`User` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


INSERT INTO Address (street, city, state, zipcode) VALUES ('Alexandru Moruzzi', 'Bucuresti', 'DA', '12345');
INSERT INTO Address (street, city, state, zipcode) VALUES ('Dr Paul Olereanu', 'Craiova', 'NU', '65434');
INSERT INTO Address (street, city, state, zipcode) VALUES ('Apolodor', 'Constanta', 'DA', '41234');
INSERT INTO Address (street, city, state, zipcode) VALUES ('Poenaru Bordea', 'Valsui', 'NU', '33556');
INSERT INTO Address (street, city, state, zipcode) VALUES ('Sfintii Apostoli', 'Buzau', 'DA', '93736');
INSERT INTO Address (street, city, state, zipcode) VALUES ('Ardeleni', 'Timisoara', 'NU', '94301');
INSERT INTO Address (street, city, state, zipcode) VALUES ('Dragos Voda', 'Pitesti', 'DA', '52556');
INSERT INTO Address (street, city, state, zipcode) VALUES ('Episcop Radu', 'Ploiesti', 'NU', '94707');


INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('irina@yahoo.com', '$2a$10$9eN270Za48.dkqnnaoi/seC.BVnjy4EcuxEmtgWWd/yw3UbdrG9C.', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values  ('pacient@gmail.com', '$2a$10$9eN270Za48.dkqnnaoi/seC.BVnjy4EcuxEmtgWWd/yw3UbdrG9C.', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('doctor@gmail.com', '$2a$10$Da.0ppK8Ah65IKboW4m.Y.AoZrh/7qBK5E4c6LBg3kkJt1J8WBpKq', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('admin@gmail.com', '$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('pacient@yahoo.com', '$2a$10$9eN270Za48.dkqnnaoi/seC.BVnjy4EcuxEmtgWWd/yw3UbdrG9C.', TRUE);
INSERT INTO User (EMAIL, `PASSWORD`, ENABLED) values ('doctor1@gmail.com', '$2a$10$Da.0ppK8Ah65IKboW4m.Y.AoZrh/7qBK5E4c6LBg3kkJt1J8WBpKq', TRUE);

INSERT INTO Authority (EMAIL, AUTHORITY) values ('irina@yahoo.com', 'ROLE_PATIENT');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('patient@gmail.com', 'ROLE_PATIENT');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('doctor@gmail.com', 'ROLE_DOCTOR');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('admin@gmail.com', 'ROLE_ADMIN');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('pacient@yahoo.com', 'ROLE_PATIENT');
INSERT INTO Authority (EMAIL, AUTHORITY) values ('doctor1@gmail.com', 'ROLE_DOCTOR');

INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Sima', 'Irina', '1995-08-06', 'FEMALE', '1111', '0720032000', 1, 1);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Popescu', 'Marius', '1992-06-06', 'MALE', '2222', '0720032001', 2, 2);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Grigore', 'Ioana', '2008-03-03', 'FEMALE', '3333', '0720032002', 3, 3);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Vlad', 'Ionut', '2009-04-04', 'MALE', '4444', '0720032003', 4, 4);
INSERT INTO Patient (FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, SSN, PHONE, ADDRESS_ID, USER_ID) VALUES ('Gheorghe', 'Vasile', '2005-05-05', 'MALE', '5555', '0720032004', 5, 5);

INSERT INTO Doctor(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, LICENSE_NUMBER, SPECIALIZATION, PHONE, ADDRESS_ID, USER_ID) VALUES ('Sima', 'Emanuel', '1977-06-06', 'MALE', '6666', 'ORTODONTIE', '0720002001', 6, 3);
INSERT INTO Doctor(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, LICENSE_NUMBER, SPECIALIZATION, PHONE, ADDRESS_ID, USER_ID) VALUES ('Sima', 'Lucian', '1988-07-07', 'MALE', '7777', 'CHIRURGIE', '0720022003', 7, 6);

INSERT INTO Admin(FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, GENDER, STAFF_NUMBER, PHONE, ADDRESS_ID, USER_ID) VALUES ('Admin', 'Admin', '2008-08-08', 'MALE', '8888', '0720032005', 8, 4);

INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2017-08-13', '', '150', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2017-08-12', '', '250', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2017-08-11', '', '350', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2017-08-10', '', '450', 'NEW');
INSERT INTO Invoice(DATE_CREATED, CCARD_4DIGITS, AMOUNT, `STATUS`) VALUES ('2017-08-09', '', '550', 'NEW');

INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2017-08-09', '2:00PM', 'Albire dinti', '200', 'NEW', 1, 1, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2017-08-10', '3:00PM', 'Extractie dinte', '300', 'NEW', 2, 2, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2017-08-16', '4:00PM', 'Durere de masea', '400', 'NEW', 1, 2, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2017-08-16', '5:00PM', 'Gingivita', '500', 'NEW', 2, 2, 1);
INSERT INTO Appointment(`DATE`, `TIME`, DESCRIPTION, ROOM, STATUS, DOCTOR_ID, INVOICE_ID, PATIENT_ID) VALUES ('2017-08-16', '6:00PM', 'Plomba', '600', 'NEW', 1, 1, 1);


