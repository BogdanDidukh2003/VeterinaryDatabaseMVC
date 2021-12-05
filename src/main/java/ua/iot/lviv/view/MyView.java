package ua.iot.lviv.view;

import ua.iot.lviv.controller.implementation.*;
import ua.iot.lviv.exception.OwnDateTimeException;
import ua.iot.lviv.exception.OwnPriceFormatException;
import ua.iot.lviv.exception.OwnTimeException;
import ua.iot.lviv.model.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyView {

    private final ClientController clientController = new ClientController();
    private final DiagnosisController diagnosisController = new DiagnosisController();
    private final DoctorController doctorController = new DoctorController();
    private final PetController petController = new PetController();
    private final ScheduleController scheduleController = new ScheduleController();
    private final TreatmentController treatmentController = new TreatmentController();
    private final VisitController visitController = new VisitController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    private final static String getIdUpdate = "Enter id of entity you want to update: ";
    private final static String getIdDelete = "Enter id of entity you want to delete: ";

    public MyView() {
        menu = new LinkedHashMap<>();

        menu.put("11", "11 - get all clients");
        menu.put("12", "12 - get client by id");
        menu.put("13", "13 - create new client");
        menu.put("14", "14 - update client");
        menu.put("15", "15 - delete client");

        menu.put("21", "21 - get all diagnosis");
        menu.put("22", "22 - get diagnosis by id");
        menu.put("23", "23 - create new diagnosis");
        menu.put("24", "24 - update diagnosis");
        menu.put("25", "25 - delete diagnosis");

        menu.put("31", "31 - get all doctors");
        menu.put("32", "32 - get doctor by id");
        menu.put("33", "33 - create new doctor");
        menu.put("34", "34 - update doctor");
        menu.put("35", "35 - delete doctor");

        menu.put("41", "41 - get all pets");
        menu.put("42", "42 - get pet by id");
        menu.put("43", "43 - create new pet");
        menu.put("44", "44 - update pet");
        menu.put("45", "45 - delete pet");

        menu.put("51", "51- get schedule");
        menu.put("52", "52- get from schedule by id");
        menu.put("53", "53- create new schedule");
        menu.put("54", "54- update schedule");
        menu.put("55", "55 - delete schedule");

        menu.put("61", "61- get all treatments");
        menu.put("62", "62- get treatment by id");
        menu.put("63", "63- create new treatment");
        menu.put("64", "64- update treatment");
        menu.put("65", "65 - delete treatment");

        menu.put("71", "71- get all visits");
        menu.put("72", "72- get visit by id");
        menu.put("73", "73- create new visit");
        menu.put("74", "74- update visit");
        menu.put("75", "75 - delete visit");

        menu.put("Q", "Q - exit");

        methodsMenu = new LinkedHashMap<>();

        methodsMenu.put("11", this::getAllClients);
        methodsMenu.put("12", this::getClientById);
        methodsMenu.put("13", this::createClient);
        methodsMenu.put("14", this::updateClient);
        methodsMenu.put("15", this::deleteClient);

        methodsMenu.put("21", this::getAllDiagnoses);
        methodsMenu.put("22", this::getDiagnosisById);
        methodsMenu.put("23", this::createDiagnosis);
        methodsMenu.put("24", this::updateDiagnosis);
        methodsMenu.put("25", this::deleteDiagnosis);

        methodsMenu.put("31", this::getAllDoctors);
        methodsMenu.put("32", this::getDoctorById);
        methodsMenu.put("33", this::createDoctor);
        methodsMenu.put("34", this::updateDoctor);
        methodsMenu.put("35", this::deleteDoctor);

        methodsMenu.put("41", this::getAllPets);
        methodsMenu.put("42", this::getPetById);
        methodsMenu.put("43", this::createPet);
        methodsMenu.put("44", this::updatePet);
        methodsMenu.put("45", this::deletePet);

        methodsMenu.put("51", this::getAllSchedule);
        methodsMenu.put("52", this::getScheduleById);
        methodsMenu.put("53", this::createSchedule);
        methodsMenu.put("54", this::updateSchedule);
        methodsMenu.put("55", this::deleteSchedule);

        methodsMenu.put("61", this::getAllTreatments);
        methodsMenu.put("62", this::getTreatmentById);
        methodsMenu.put("63", this::createTreatment);
        methodsMenu.put("64", this::updateTreatment);
        methodsMenu.put("65", this::deleteTreatment);

        methodsMenu.put("71", this::getAllVisits);
        methodsMenu.put("72", this::getVisitById);
        methodsMenu.put("73", this::createVisit);
        methodsMenu.put("74", this::updateVisit);
        methodsMenu.put("75", this::deleteVisit);
    }

    //-----------------------------------------------------------------------
    private void getAllClients() {
        System.out.println("\tTable 'client'");
        clientController.getAll();
    }

    private void getClientById() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        clientController.getById(id);
    }

    private void createClient() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.print("Enter first name:");
        String firstName = INPUT.nextLine();
        System.out.print("Enter name:");
        String name = INPUT.nextLine();
        System.out.print("Enter last name:");
        String lastName = INPUT.nextLine();
        ClientEntity entity = new ClientEntity(id, firstName, name, lastName);
        clientController.create(entity);
    }

    private void updateClient() {
        System.out.println(getIdUpdate);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.print("Enter first name:");
        String firstName = INPUT.nextLine();
        System.out.print("Enter name:");
        String name = INPUT.nextLine();
        System.out.print("Enter last name:");
        String lastName = INPUT.nextLine();

        ClientEntity oldEntity = clientController.getEntityById(id);
        if (oldEntity == null) {
            return;
        }
        oldEntity.setFirstName(firstName);
        oldEntity.setName(name);
        oldEntity.setLastName(lastName);
        clientController.update(oldEntity);
    }

    private void deleteClient() {
        System.out.println(getIdDelete);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        clientController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllDiagnoses() {
        System.out.println("\tTable 'diagnosis'");
        diagnosisController.getAll();
    }

    private void getDiagnosisById() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        diagnosisController.getById(id);
    }

    private void createDiagnosis() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.print("Enter diagnosis:");
        String diagnosis = INPUT.nextLine();
        System.out.print("Enter treatment:");
        String treatment = INPUT.nextLine();
        DiagnosisEntity entity = new DiagnosisEntity(id, diagnosis, treatment);
        diagnosisController.create(entity);
    }

    private void updateDiagnosis() {
        System.out.println(getIdUpdate);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.print("Enter diagnosis:");
        String diagnosis = INPUT.nextLine();
        System.out.print("Enter treatment:");
        String treatment = INPUT.nextLine();
        DiagnosisEntity entity = new DiagnosisEntity(id, diagnosis, treatment);

        DiagnosisEntity oldEntity = diagnosisController.getEntityById(id);
        if (oldEntity == null) {
            return;
        }
        oldEntity.setDiagnosis(diagnosis);
        oldEntity.setTreatment(treatment);
        diagnosisController.update(entity);
    }

    private void deleteDiagnosis() {
        System.out.println(getIdDelete);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        diagnosisController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllDoctors() {
        System.out.println("\tTable 'doctor'");
        doctorController.getAll();
    }

    private void getDoctorById() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        doctorController.getById(id);
    }

    private void createDoctor() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter first name:");
        String firstName = INPUT.nextLine();
        System.out.println("Enter name:");
        String name = INPUT.nextLine();
        System.out.println("Enter last name:");
        String lastName = INPUT.nextLine();
        System.out.println("Enter year of birth:");
        int yearOfBirth = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter speciality:");
        String speciality = INPUT.nextLine();
        DoctorEntity entity = new DoctorEntity(id, firstName, name, lastName, yearOfBirth, speciality);
        doctorController.create(entity);
    }

    private void updateDoctor() {
        System.out.println(getIdUpdate);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter first name:");
        String firstName = INPUT.nextLine();
        System.out.println("Enter name:");
        String name = INPUT.nextLine();
        System.out.println("Enter last name:");
        String lastName = INPUT.nextLine();
        System.out.println("Enter year of birth:");
        int yearOfBirth = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter speciality:");
        String speciality = INPUT.nextLine();

        DoctorEntity oldEntity = doctorController.getEntityById(id);
        if (oldEntity == null) {
            return;
        }
        oldEntity.setFirstName(firstName);
        oldEntity.setName(name);
        oldEntity.setLastName(lastName);
        oldEntity.setYearOfBirth(yearOfBirth);
        oldEntity.setSpeciality(speciality);
        doctorController.update(oldEntity);
    }

    private void deleteDoctor() {
        System.out.println(getIdDelete);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        doctorController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllPets() {
        System.out.println("\tTable 'pet'");
        petController.getAll();
    }

    private void getPetById() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        petController.getById(id);
    }

    private void createPet() throws DateTimeParseException {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter animal species:");
        String animalSpecies = INPUT.nextLine();
        System.out.println("Enter name:");
        String name = INPUT.nextLine();
        System.out.println("Enter weight in kg:");
        int weightInKg = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter length in cm:");
        int lengthInCm = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter date of birth in format: MM/dd/yyyy, example: \"07/28/2011\":");
        String dateStr = INPUT.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateLocalDate = LocalDate.parse(dateStr, formatter);
        Date date = Date.valueOf(dateLocalDate);
        System.out.println("Enter client id:");
        Long clientId = INPUT.nextLong();
        INPUT.nextLine();
        ClientEntity client = clientController.getEntityById(clientId);
        PetEntity entity = new PetEntity(id, animalSpecies, name, weightInKg, lengthInCm, date, client);
        petController.create(entity);
    }

    private void updatePet() throws DateTimeParseException {
        System.out.println(getIdUpdate);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter animal species:");
        String animalSpecies = INPUT.nextLine();
        System.out.println("Enter name:");
        String name = INPUT.nextLine();
        System.out.println("Enter weight in kg:");
        int weightInKg = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter length in cm:");
        int lengthInCm = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter date of birth in format: MM/dd/yyyy, example: \"07/28/2011\":");
        String dateStr = INPUT.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateLocalDate = LocalDate.parse(dateStr, formatter);
        Date date = Date.valueOf(dateLocalDate);
        System.out.println("Enter client id:");
        Long clientId = INPUT.nextLong();
        INPUT.nextLine();
        ClientEntity client = clientController.getEntityById(clientId);

        PetEntity oldEntity = petController.getEntityById(id);
        if (oldEntity == null) {
            return;
        }
        oldEntity.setAnimalSpecies(animalSpecies);
        oldEntity.setName(name);
        oldEntity.setWeightKg(weightInKg);
        oldEntity.setLengthCm(lengthInCm);
        oldEntity.setDateOfBirth(date);
        oldEntity.setClientByClientId(client);
        petController.update(oldEntity);
    }

    private void deletePet() {
        System.out.println(getIdDelete);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        petController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllSchedule() {
        System.out.println("\tTable 'schedule'");
        scheduleController.getAll();
    }

    private void getScheduleById() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        scheduleController.getById(id);
    }

    private void createSchedule() throws OwnTimeException {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        Time timeStart;
        Time timeEnd;
        try {
            System.out.println("Enter time of start in format: HH:mm:ss, example: \"10:45:00\":");
            String timeStartStr = INPUT.nextLine();
            timeStart = Time.valueOf(timeStartStr);
            System.out.println("Enter time of end in format: HH:mm:ss, example: \"18:45:00\":");
            String timeEndStr = INPUT.nextLine();
            timeEnd = Time.valueOf(timeEndStr);
        } catch (Exception e) {
            throw new OwnTimeException("own time exception!");
        }
        System.out.println("Enter week day:");
        String weekDay = INPUT.nextLine();
        System.out.println("Enter doctor id:");
        Long doctorId = INPUT.nextLong();
        INPUT.nextLine();
        DoctorEntity doctor = doctorController.getEntityById(doctorId);
        ScheduleEntity entity = new ScheduleEntity(id, timeStart, timeEnd, weekDay, doctor);
        scheduleController.create(entity);
    }

    private void updateSchedule() throws OwnTimeException {
        System.out.println(getIdUpdate);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        Time timeStart;
        Time timeEnd;
        try {
            System.out.println("Enter time of start in format: HH:mm:ss, example: \"10:45:00\":");
            String timeStartStr = INPUT.nextLine();
            timeStart = Time.valueOf(timeStartStr);
            System.out.println("Enter time of end in format: HH:mm:ss, example: \"18:45:00\":");
            String timeEndStr = INPUT.nextLine();
            timeEnd = Time.valueOf(timeEndStr);
        } catch (Exception e) {
            throw new OwnTimeException("own time exception!");
        }
        System.out.println("Enter week day:");
        String weekDay = INPUT.nextLine();
        System.out.println("Enter doctor id:");
        Long doctorId = INPUT.nextLong();
        INPUT.nextLine();
        DoctorEntity doctor = doctorController.getEntityById(doctorId);

        ScheduleEntity oldEntity = scheduleController.getEntityById(id);
        if (oldEntity == null) {
            return;
        }
        oldEntity.setTimeStart(timeStart);
        oldEntity.setTimeEnd(timeEnd);
        oldEntity.setWeekDay(weekDay);
        oldEntity.setDoctorByDoctorId(doctor);
        scheduleController.update(oldEntity);
    }

    private void deleteSchedule() {
        System.out.println(getIdDelete);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        scheduleController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllTreatments() {
        System.out.println("\tTable 'treatment'");
        treatmentController.getAll();
    }

    private void getTreatmentById() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        treatmentController.getById(id);
    }

    private void createTreatment() throws OwnPriceFormatException {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter name:");
        String name = INPUT.nextLine();
        System.out.println("Enter description:");
        String description = INPUT.nextLine();
        System.out.println("Enter price in USD in format \"####,##\", example: \"55,25\", \"255,5\":");
        BigDecimal priceUSD;
        try {
            priceUSD = INPUT.nextBigDecimal();
            INPUT.nextLine();
        } catch (Exception e) {
            INPUT.nextLine();
            throw new OwnPriceFormatException("own price format exception!");
        }
        TreatmentEntity entity = new TreatmentEntity(id, name, description, priceUSD);
        treatmentController.create(entity);
    }

    private void updateTreatment() throws OwnPriceFormatException {
        System.out.println(getIdUpdate);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter name:");
        String name = INPUT.nextLine();
        System.out.println("Enter description:");
        String description = INPUT.nextLine();
        System.out.println("Enter price in USD in format \"####,##\", example: \"55,25\", \"255,5\":");
        BigDecimal priceUSD;
        try {
            priceUSD = INPUT.nextBigDecimal();
            INPUT.nextLine();
        } catch (Exception e) {
            INPUT.nextLine();
            throw new OwnPriceFormatException("own price format exception!");
        }

        TreatmentEntity oldEntity = treatmentController.getEntityById(id);
        if (oldEntity == null) {
            return;
        }
        oldEntity.setName(name);
        oldEntity.setDescription(description);
        oldEntity.setPriceUsd(priceUSD);
        treatmentController.update(oldEntity);
    }

    private void deleteTreatment() {
        System.out.println(getIdDelete);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        treatmentController.delete(id);
    }

    //-----------------------------------------------------------------------
    private void getAllVisits() {
        System.out.println("\tTable 'visit'");
        visitController.getAll();
    }

    private void getVisitById() {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        visitController.getById(id);
    }

    private void createVisit() throws OwnDateTimeException {
        System.out.println("Enter id: ");
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter date and time in format: MM/dd/yyyy HH:mm, example: \"07/28/2011 09:30\":");
        String dateTimeStr = INPUT.nextLine();
        Timestamp timestamp;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            timestamp = Timestamp.valueOf(dateTime);
        } catch (DateTimeParseException e) {
            throw new OwnDateTimeException("DateTime format is incorrect!");
        }
        System.out.println("Enter pet id:");
        Long petId = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter treatment id:");
        Long treatmentId = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter schedule id:");
        Long scheduleId = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter diagnosis id:");
        Long diagnosisId = INPUT.nextLong();
        INPUT.nextLine();

        PetEntity pet = petController.getEntityById(petId);
        TreatmentEntity treatment = treatmentController.getEntityById(treatmentId);
        ScheduleEntity schedule = scheduleController.getEntityById(scheduleId);
        DiagnosisEntity diagnosis = diagnosisController.getEntityById(diagnosisId);

        VisitEntity entity = new VisitEntity(id, timestamp, pet, treatment, schedule, diagnosis);
        visitController.create(entity);
    }

    private void updateVisit() throws OwnDateTimeException {
        System.out.println(getIdUpdate);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter date and time in format: MM/dd/yyyy HH:mm, example: \"07/28/2011 09:30\":");
        String dateTimeStr = INPUT.nextLine();
        Timestamp timestamp;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            timestamp = Timestamp.valueOf(dateTime);
        } catch (DateTimeParseException e) {
            throw new OwnDateTimeException("DateTime format is incorrect!");
        }
        System.out.println("Enter pet id:");
        Long petId = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter treatment id:");
        Long treatmentId = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter schedule id:");
        Long scheduleId = INPUT.nextLong();
        INPUT.nextLine();
        System.out.println("Enter diagnosis id:");
        Long diagnosisId = INPUT.nextLong();
        INPUT.nextLine();

        PetEntity pet = petController.getEntityById(petId);
        TreatmentEntity treatment = treatmentController.getEntityById(treatmentId);
        ScheduleEntity schedule = scheduleController.getEntityById(scheduleId);
        DiagnosisEntity diagnosis = diagnosisController.getEntityById(diagnosisId);

        VisitEntity oldEntity = visitController.getEntityById(id);
        if (oldEntity == null) {
            return;
        }
        oldEntity.setDateTime(timestamp);
        oldEntity.setPetByPetId(pet);
        oldEntity.setTreatmentByTreatmentId(treatment);
        oldEntity.setScheduleByScheduleId(schedule);
        oldEntity.setDiagnosisByDiagnosisId(diagnosis);
        visitController.update(oldEntity);
    }

    private void deleteVisit() {
        System.out.println(getIdDelete);
        Long id = INPUT.nextLong();
        INPUT.nextLine();
        visitController.delete(id);
    }

    //-----------------------------------------------------------------------

    private void showMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public void show() {
        do {
            System.out.println("\nM - show menu");
            System.out.println("Q - exit");
            String keyMenu = INPUT.nextLine().toUpperCase();
            if (keyMenu.equalsIgnoreCase("M")) {
                showMenu();
                System.out.println("Select menu point.");
                keyMenu = INPUT.nextLine().toUpperCase();
                try {
                    methodsMenu.get(keyMenu).print();
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                    System.out.println("SQLState: " + e.getSQLState());
                    System.out.println("VendorError: " + e.getErrorCode());
                } catch (NullPointerException ignored) {
                    if (keyMenu.equalsIgnoreCase("Q")) {
                        break;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Date format is incorrect! Correct format: MM/dd/yyyy, example: \"07/28/2011\"");
                } catch (InputMismatchException e) {
                    System.out.println("The input data type does not match the data type in the database!");
                    INPUT.nextLine();
                } catch (OwnPriceFormatException e) {
                    System.out.println("Price format is incorrect! Correct format: \"####,##\", example: \"55,25\", \"255,5\"");
                } catch (OwnDateTimeException e) {
                    System.out.println("DateTime format is incorrect! Correct format: MM/dd/yyyy HH:mm, example: \"07/28/2011 09:30\"");
                } catch (OwnTimeException e) {
                    System.out.println("Time format is incorrect! Correct format: HH:mm:ss, example: \"10:45:00\"");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("\nSomething went wrong. Please try later");
                }
            } else if (keyMenu.equalsIgnoreCase("Q")) {
                break;
            }
        } while (true);
    }

}
