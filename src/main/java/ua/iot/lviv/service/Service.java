package ua.iot.lviv.service;

import ua.iot.lviv.DAO.DAO;

import java.util.List;

public interface Service<T, ID> {
    List<T> getAll();

    T getById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(ID id);

    DAO<T, ID> getDAO();
}
