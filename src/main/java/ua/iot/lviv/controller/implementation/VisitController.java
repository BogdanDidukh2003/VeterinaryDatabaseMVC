package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Visit;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.VisitService;

public class VisitController extends ControllerImpl<Visit> {
    private Service<Visit> visitService = new VisitService();

    @Override
    public Service<Visit> getService() {
        return visitService;
    }
}
