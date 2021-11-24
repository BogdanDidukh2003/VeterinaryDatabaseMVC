package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Diploma;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DiplomaService;

public class DiplomaController extends ControllerImpl<Diploma> {
    private Service<Diploma> diplomaService = new DiplomaService();

    @Override
    public Service<Diploma> getService() {
        return diplomaService;
    }
}
