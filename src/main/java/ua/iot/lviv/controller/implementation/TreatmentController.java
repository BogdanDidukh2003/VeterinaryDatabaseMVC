package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Treatment;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.TreatmentService;

public class TreatmentController extends ControllerImpl<Treatment> {
    private Service<Treatment> serviceService = new TreatmentService();

    @Override
    public Service<Treatment> getService() {
        return serviceService;
    }
}
