package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.model.Diagnosis;
import ua.iot.lviv.model.implementation.DiagnosisImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DiagnosisDAO implements DAO<Diagnosis, Integer> {
    private static final String GET_ALL = "SELECT * FROM bogdan_didukh.diagnosis";
    private static final String GET_BY_ID = "SELECT * FROM bogdan_didukh.diagnosis WHERE id=?";
    private static final String CREATE = "INSERT bogdan_didukh.diagnosis "
            + "(id, diagnosis, treatment) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE bogdan_didukh.diagnosis"
            + " SET diagnosis=?, treatment=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bogdan_didukh.diagnosis WHERE id=?";

    @Override
    public List<Diagnosis> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Diagnosis> diagnosises = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String diagnosis = resultSet.getString(2);
                    String treatment = resultSet.getString(3);
                    diagnosises.add(new DiagnosisImpl(id, diagnosis, treatment));
                }
            }
        }
        return diagnosises;
    }

    @Override
    public Diagnosis getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Diagnosis diagnosis = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String diagnosisstr = resultSet.getString(2);
                    String treatment = resultSet.getString(3);
                    diagnosis = new DiagnosisImpl(id, diagnosisstr, treatment);
                }
            }
        }
        return diagnosis;
    }

    @Override
    public int create(Diagnosis entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setString(2, entity.getDiagnosis());
            pstatement.setString(3, entity.getTreatment());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Diagnosis entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setString(1, entity.getDiagnosis());
            pstatement.setString(2, entity.getTreatment());
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
