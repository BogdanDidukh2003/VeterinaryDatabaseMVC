package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.model.DoctorHasTreatment;
import ua.iot.lviv.model.implementation.DoctorHasTreatmentImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DoctorHasTreatmentDAO implements DAO<DoctorHasTreatment, Integer> {
    private static final String GET_ALL = "SELECT * FROM bogdan_didukh.doctor_has_treatment";
    private static final String GET_BY_ID = "SELECT * FROM bogdan_didukh.doctor_has_treatment WHERE id=?";
    private static final String CREATE = "INSERT bogdan_didukh.doctor_has_treatment "
            + "(id, doctor_id, treatment_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE bogdan_didukh.doctor_has_treatment"
            + " SET doctor_id=?, treatment_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM bogdan_didukh.doctor_has_treatment WHERE id=?";

    @Override
    public List<DoctorHasTreatment> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<DoctorHasTreatment> doctorHasTreatments = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer doctorId = resultSet.getInt(2);
                    Integer treatmentId = resultSet.getInt(3);
                    doctorHasTreatments.add(new DoctorHasTreatmentImpl(id, doctorId, treatmentId));
                }
            }
        }
        return doctorHasTreatments;
    }

    @Override
    public DoctorHasTreatment getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        DoctorHasTreatment doctorHasTreatment = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer doctorId = resultSet.getInt(2);
                    Integer treatmentId = resultSet.getInt(3);
                    doctorHasTreatment = new DoctorHasTreatmentImpl(id, doctorId, treatmentId);
                }
            }
        }
        return doctorHasTreatment;
    }

    @Override
    public int create(DoctorHasTreatment entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setInt(2, entity.getDoctorId());
            pstatement.setInt(3, entity.getTreatmentId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(DoctorHasTreatment entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setInt(1, entity.getDoctorId());
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