package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.DoctorEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DoctorService;

public class DoctorController extends ControllerImpl<DoctorEntity, Long> {
    final Service<DoctorEntity, Long> service = new DoctorService();

    @Override
    public Service<DoctorEntity, Long> getService() {
        return service;
    }
}

