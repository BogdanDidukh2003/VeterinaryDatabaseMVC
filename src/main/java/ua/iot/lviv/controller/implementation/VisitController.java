package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.VisitEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.VisitService;

public class VisitController extends ControllerImpl<VisitEntity, Long> {
    final Service<VisitEntity, Long> service = new VisitService();

    @Override
    public Service<VisitEntity, Long> getService() {
        return service;
    }
}