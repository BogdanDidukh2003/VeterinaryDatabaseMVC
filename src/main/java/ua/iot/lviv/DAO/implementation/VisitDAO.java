package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.model.Visit;
import ua.iot.lviv.model.implementation.VisitImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class VisitDAO implements DAO<Visit, Integer> {
    private static final String GET_ALL = "SELECT * FROM bogdan_didukh.visit";
    private static final String GET_BY_ID = "SELECT * FROM bogdan_didukh.visit WHERE id=?";
    private static final String CREATE = "INSERT bogdan_didukh.visit "
            + "(id, date_time, client_has_pet_id, treatment_id, schedule_id, diagnosis_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE bogdan_didukh.visit"
            + " SET date_time=?, client_has_pet_id=?, treatment_id=?, schedule_id=?, diagnosis_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bogdan_didukh.visit WHERE id=?";

    @Override
    public List<Visit> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Visit> visits = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    LocalDateTime dateTime = resultSet.getObject(2, LocalDateTime.class);
                    Integer clientHasPetId = resultSet.getInt(3);
                    Integer treatmentId = resultSet.getInt(4);
                    Integer scheduleId = resultSet.getInt(5);
                    Integer diagnosisId = resultSet.getInt(6);
                    visits.add(new VisitImpl(id, dateTime, clientHasPetId, treatmentId, scheduleId, diagnosisId));
                }
            }
        }
        return visits;
    }

    @Override
    public Visit getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Visit visit = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    LocalDateTime dateTime = resultSet.getObject(2, LocalDateTime.class);
//                    Date dateTimeSql = resultSet.getDate(2);
//                    LocalDateTime dateTime = new Timestamp(dateTimeSql.getTime()).toLocalDateTime();
                    Integer clientHasPetId = resultSet.getInt(3);
                    Integer treatmentId = resultSet.getInt(4);
                    Integer scheduleId = resultSet.getInt(5);
                    Integer diagnosisId = resultSet.getInt(6);
                    visit = new VisitImpl(id, dateTime, clientHasPetId, treatmentId, scheduleId, diagnosisId);
                }
            }
        }
        return visit;
    }

    @Override
    public int create(Visit entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setObject(2, entity.getDateTime());
            pstatement.setInt(3, entity.getClientHasPetId());
            pstatement.setInt(4, entity.getTreatmentId());
            pstatement.setInt(5, entity.getScheduleId());
            pstatement.setInt(6, entity.getDiagnosisId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Visit entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setObject(1, entity.getDateTime());
            pstatement.setInt(2, entity.getClientHasPetId());
            pstatement.setInt(3, entity.getTreatmentId());
            pstatement.setInt(4, entity.getScheduleId());
            pstatement.setInt(5, entity.getDiagnosisId());
            pstatement.setInt(6, entity.getId());
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
