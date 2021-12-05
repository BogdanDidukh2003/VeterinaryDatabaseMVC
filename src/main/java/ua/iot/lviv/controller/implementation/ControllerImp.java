package ua.iot.lviv.controller.implementation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.iot.lviv.controller.Controller;
import ua.iot.lviv.domain.Entity;
import ua.iot.lviv.service.Service;

import java.util.List;

@RequestMapping("/api")
public abstract class ControllerImp<T extends Entity> implements Controller<T> {

    public abstract Service<T> getService();

    @Override
    @GetMapping("/")
    public ResponseEntity<List<T>> findAll() {
        List<T> entityList = getService().findAll();
        if (entityList == null) {
            return new ResponseEntity("404", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(entityList, HttpStatus.OK);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        T entity = getService().find(id);
        if (entity == null) {
            return new ResponseEntity("404", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }

    @Override
    @PostMapping("")
    public ResponseEntity<T> create(@RequestBody T entity) {
        T createdEntity = getService().create(entity);
        if (createdEntity == null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T entity) {
        entity.setId(id);
        T updatedEntity = getService().update(entity);
        if (updatedEntity == null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<T> delete(@PathVariable Long id) {
        T deletedEntity = getService().delete(id);
        if (deletedEntity == null) {
            return new ResponseEntity("404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedEntity, HttpStatus.OK);
    }
}
