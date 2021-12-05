package ua.iot.lviv.controller;

import ua.iot.lviv.service.Service;


public interface Controller<T, ID> {
    void getAll();

    void getById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(ID id);

    Service<T, ID> getService();

    T getEntityById(ID id);
}