package ua.iot.lviv.controller;

import ua.iot.lviv.service.Service;

import java.sql.SQLException;

public interface Controller<T> {
    void getAll() throws SQLException;

    void getById(Integer id) throws SQLException;

    void create(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(Integer id) throws SQLException;

    Service<T> getService();
}
