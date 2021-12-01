package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.model.Treatment;
import ua.iot.lviv.model.implementation.TreatmentImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.math.BigDecimal;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TreatmentDAO implements DAO<Treatment, Integer> {
    private static final String GET_ALL = "SELECT * FROM bogdan_didukh.treatment";
    private static final String GET_BY_ID = "SELECT * FROM bogdan_didukh.treatment WHERE id=?";
    private static final String CREATE = "INSERT bogdan_didukh.treatment "
            + "(id, name, description, price_usd) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE bogdan_didukh.treatment"
            + " SET name=?, description=?, price_usd=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bogdan_didukh.treatment WHERE id=?";

    @Override
    public List<Treatment> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Treatment> treatments = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    BigDecimal priceUSD = resultSet.getBigDecimal(4);
                    treatments.add(new TreatmentImpl(id, name, description, priceUSD));
                }
            }
        }
        return treatments;
    }

    @Override
    public Treatment getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Treatment treatment = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    BigDecimal priceUSD = resultSet.getBigDecimal(4);
                    treatment = new TreatmentImpl(id, name, description, priceUSD);
                }
            }
        }
        return treatment;
    }

    @Override
    public int create(Treatment entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setString(2, entity.getName());
            pstatement.setString(3, entity.getDescription());
            pstatement.setBigDecimal(4, entity.getPriceUSD());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Treatment entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setString(1, entity.getName());
            pstatement.setString(2, entity.getDescription());
            pstatement.setBigDecimal(3, entity.getPriceUSD());
            pstatement.setInt(4, entity.getId());
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
