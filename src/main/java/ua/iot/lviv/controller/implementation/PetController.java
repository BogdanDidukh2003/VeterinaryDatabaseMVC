package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.PetEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.PetService;

public class PetController extends ControllerImpl<PetEntity, Long> {
    final Service<PetEntity, Long> service = new PetService();

    @Override
    public Service<PetEntity, Long> getService() {
        return service;
    }
}

