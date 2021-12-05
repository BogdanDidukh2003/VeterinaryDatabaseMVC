package ua.iot.lviv.service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface Service<T> {
    JpaRepository<T, Long> getRepository();

    List<T> findAll();

    T find(Long id);

    @Transactional
    T create(T entity);

    @Transactional
    T update(T entity);

    @Transactional
    T delete(Long id);
}
