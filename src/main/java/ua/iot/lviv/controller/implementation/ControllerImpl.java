package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.controller.Controller;
import ua.iot.lviv.service.Service;

import java.util.List;

public abstract class ControllerImpl<T, ID> implements Controller<T, ID> {

    @Override
    public abstract Service<T, ID> getService();

    @Override
    public T getEntityById(ID id) {
        T entity = getService().getById(id);
        if (entity != null) {
            return entity;
        } else {
            System.out.println("Entity with id = " + id + " not found");
            return null;
        }
    }

    @Override
    public void getAll() {
        List<T> listObj = getService().getAll();
        if (listObj.isEmpty()) {
            System.out.println("Table is empty");
        } else {
            for (T obj : listObj) {
                System.out.println(obj);
            }
        }
    }

    @Override
    public void getById(ID id) {
        T obj = getService().getById(id);
        if (obj != null) {
            System.out.println(obj);
        } else {
            System.out.println("Entity with id = " + id + " not found");
        }
    }

    @Override
    public void create(T entity) {
        try {
            getService().create(entity);
            System.out.println("Entity has been created");
        } catch (Exception e) {
            System.out.println("Entity has NOT been created, check your input values");
        }
    }

    @Override
    public void update(T entity) {
        try {
            getService().update(entity);
            System.out.println("Entity has been updated");
        } catch (Exception e) {
            System.out.println("Entity has NOT been updated, check your input values");
        }
    }

    @Override
    public void delete(ID id) {
        try {
            getService().delete(id);
            System.out.println("Entity has been deleted");
        } catch (Exception e) {
            System.out.println("Entity has NOT been deleted, check your input values");
        }
    }
}
