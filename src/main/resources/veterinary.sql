CREATE SCHEMA IF NOT EXISTS bogdan_didukh DEFAULT CHARACTER SET utf8;
USE bogdan_didukh;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS diagnosis;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS treatment;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS visit;
SET foreign_key_checks = 1;


CREATE TABLE IF NOT EXISTS client
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    name       VARCHAR(45) NOT NULL,
    last_name  VARCHAR(45)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS diagnosis
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    diagnosis VARCHAR(300) NOT NULL,
    treatment MEDIUMTEXT
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS doctor
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(45) NOT NULL,
    name          VARCHAR(45) NOT NULL,
    last_name     VARCHAR(45),
    year_of_birth INT         NOT NULL,
    speciality    VARCHAR(45)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS pet
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    animal_species VARCHAR(45) NOT NULL,
    client_id      BIGINT      NOT NULL,
    name           VARCHAR(45),
    weight_kg      INT,
    length_cm      INT,
    date_of_birth  DATE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS treatment
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(80)   NOT NULL,
    description MEDIUMTEXT,
    price_usd   DECIMAL(5, 2) NOT NULL
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS schedule
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    doctor_id  BIGINT      NOT NULL,
    time_start TIME        NOT NULL,
    time_end   TIME        NOT NULL,
    week_day   VARCHAR(15) NOT NULL
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS visit
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_time    DATETIME NOT NULL,
    pet_id       BIGINT   NOT NULL,
    treatment_id BIGINT   NOT NULL,
    schedule_id  BIGINT   NOT NULL,
    diagnosis_id BIGINT   NOT NULL
)
    ENGINE = InnoDB;

-- -------------------------------------------------

ALTER TABLE pet
    ADD CONSTRAINT fk_pet_client1
        FOREIGN KEY (client_id)
            REFERENCES client (id);

ALTER TABLE schedule
    ADD CONSTRAINT fk_schedule_doctor
        FOREIGN KEY (doctor_id)
            REFERENCES doctor (id);

ALTER TABLE visit
    ADD CONSTRAINT fk_visit_pet1
        FOREIGN KEY (pet_id)
            REFERENCES pet (id),
    ADD CONSTRAINT fk_visit_treatment1
        FOREIGN KEY (treatment_id)
            REFERENCES treatment (id),
    ADD CONSTRAINT fk_visit_schedule1
        FOREIGN KEY (schedule_id)
            REFERENCES schedule (id),
    ADD CONSTRAINT fk_visit_diagnosis1
        FOREIGN KEY (diagnosis_id)
            REFERENCES diagnosis (id);


INSERT INTO client (id, first_name, name, last_name)
VALUES (1, 'Ivanov', 'Ivan', 'Ivanovych'),
       (2, 'Ivanov', 'Ivan', 'Ivanovych'),
       (3, 'Ivanov', 'Ivan', 'Ivanovych'),
       (4, 'Ivanov', 'Ivan', 'Ivanovych'),
       (5, 'Ivanov', 'Ivan', 'Ivanovych'),
       (6, 'Ivanov', 'Ivan', 'Ivanovych'),
       (7, 'Ivanov', 'Ivan', 'Ivanovych'),
       (8, 'Ivanov', 'Ivan', 'Ivanovych');

INSERT INTO diagnosis (id, diagnosis, treatment)
VALUES (1, 'cancer', Null),
       (2, 'insult', Null),
       (3, 'infarct', Null),
       (4, 'gematoma', Null),
       (5, 'flue', Null);

INSERT INTO doctor (id, first_name, name, last_name, year_of_birth, speciality)
VALUES (1, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon'),
       (2, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon'),
       (3, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon'),
       (4, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon'),
       (5, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon'),
       (6, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon'),
       (7, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon'),
       (8, 'Ivanov', 'Ivan', 'Ivanovych', 1980, 'surgeon');

INSERT INTO pet (id, animal_species, client_id)
VALUES (1, 'fish', 2),
       (2, 'horse', 2),
       (3, 'parrot', 1),
       (4, 'hamster', 4),
       (5, 'cat', 1),
       (6, 'dog', 1),
       (7, 'turtle', 5),
       (8, 'fox', 1);

INSERT INTO treatment (id, name, price_usd)
VALUES (1, 'parazetamol', 1),
       (2, 'nifuroksazid', 1.5),
       (3, 'vaccination', 0),
       (4, 'massage', 5),
       (5, 'evkazolin', 10),
       (6, 'hoof trim', 50),
       (7, 'operation', 60),
       (8, 'amputation', 100);

INSERT INTO schedule (id, doctor_id, time_start, time_end, week_day)
VALUES (1, 2, '12:00:00', '14:00:00', 'Tuesday'),
       (2, 2, '12:00:00', '14:00:00', 'Tuesday'),
       (3, 1, '12:00:00', '14:00:00', 'Tuesday'),
       (4, 4, '12:00:00', '14:00:00', 'Tuesday'),
       (5, 1, '12:00:00', '14:00:00', 'Tuesday'),
       (6, 1, '12:00:00', '14:00:00', 'Tuesday'),
       (7, 5, '12:00:00', '14:00:00', 'Tuesday'),
       (8, 1, '12:00:00', '14:00:00', 'Tuesday');

INSERT INTO visit (id, date_time, pet_id, treatment_id, schedule_id, diagnosis_id)
VALUES (1, '2021-12-12 12:00:00', 2, 1, 1, 1),
       (2, '2021-12-12 12:00:00', 2, 1, 1, 2),
       (3, '2021-12-12 12:00:00', 2, 1, 1, 3),
       (4, '2021-12-12 12:00:00', 2, 1, 1, 4),
       (5, '2021-12-12 12:00:00', 2, 1, 1, 5),
       (6, '2021-12-12 12:00:00', 2, 1, 1, 1),
       (7, '2021-12-12 12:00:00', 2, 1, 1, 2),
       (8, '2021-12-12 12:00:00', 2, 1, 1, 3);

