package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.model.Client;
import ua.iot.lviv.model.implementation.ClientImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientDAO implements DAO<Client, Integer> {
    private static final String GET_ALL = "SELECT * FROM bogdan_didukh.client";
    private static final String GET_BY_ID = "SELECT * FROM bogdan_didukh.client WHERE id=?";
    private static final String CREATE = "INSERT bogdan_didukh.client "
            + "(id, first_name, name, last_name) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE bogdan_didukh.client"
            + " SET first_name=?, name=?, last_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM bogdan_didukh.client WHERE id=?";

    @Override
    public List<Client> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Client> clients = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    String lastName = resultSet.getString(4);
                    clients.add(new ClientImpl(id, firstName, name, lastName));
                }
            }
        }
        return clients;
    }

    @Override
    public Client getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Client client = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    String lastName = resultSet.getString(4);
                    client = new ClientImpl(id, firstName, name, lastName);
                }
            }
        }
        return client;
    }

    @Override
    public int create(Client entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setString(2, entity.getFirstName());
            pstatement.setString(3, entity.getName());
            pstatement.setString(4, entity.getLastName());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Client entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setString(1, entity.getFirstName());
            pstatement.setString(2, entity.getName());
            pstatement.setString(3, entity.getLastName());
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
