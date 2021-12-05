package ua.iot.lviv.controller;

import org.springframework.http.ResponseEntity;
import ua.iot.lviv.service.Service;

import java.util.List;

public interface Controller<T> {
    Service<T> getService();

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(Long id);

    ResponseEntity<T> create(T entity);

    ResponseEntity<T> update(Long id, T entity);

    ResponseEntity<T> delete(Long id);
}