package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.model.AnimalSpeciesHasTreatment;
import ua.iot.lviv.model.implementation.AnimalSpeciesHasTreatmentImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AnimalSpeciesHasTreatmentDAO implements DAO<AnimalSpeciesHasTreatment, Integer> {
    private static final String GET_ALL = "SELECT * FROM bogdan_didukh.animal_species_has_treatment";
    private static final String GET_BY_ID = "SELECT * FROM bogdan_didukh.animal_species_has_treatment WHERE id=?";
    private static final String CREATE = "INSERT bogdan_didukh.animal_species_has_treatment "
            + "(id, animal_species_id, treatment_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE bogdan_didukh.animal_species_has_treatment"
            + " SET animal_species_id=?, treatment_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM bogdan_didukh.animal_species_has_treatment WHERE id=?";

    @Override
    public List<AnimalSpeciesHasTreatment> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<AnimalSpeciesHasTreatment> animalSpeciesHasTreatments = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer animalSpeciesId = resultSet.getInt(2);
                    Integer treatmentId = resultSet.getInt(3);
                    animalSpeciesHasTreatments.add(new AnimalSpeciesHasTreatmentImpl(id, animalSpeciesId, treatmentId));
                }
            }
        }
        return animalSpeciesHasTreatments;
    }

    @Override
    public AnimalSpeciesHasTreatment getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        AnimalSpeciesHasTreatment animalSpeciesHasTreatment = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer animalSpeciesId = resultSet.getInt(2);
                    Integer treatmentId = resultSet.getInt(3);
                    animalSpeciesHasTreatment = new AnimalSpeciesHasTreatmentImpl(id, animalSpeciesId, treatmentId);
                }
            }
        }
        return animalSpeciesHasTreatment;
    }

    @Override
    public int create(AnimalSpeciesHasTreatment entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setInt(2, entity.getAnimalSpeciesId());
            pstatement.setInt(3, entity.getTreatmentId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(AnimalSpeciesHasTreatment entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setInt(1, entity.getAnimalSpeciesId());
            pstatement.setInt(2, entity.getTreatmentId());
            pstatement.setInt(3, entity.getId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(DELETE)) {
            pstatement.setInt(1, id);
            return pstatement.executeUpdate();
        }
    }
}