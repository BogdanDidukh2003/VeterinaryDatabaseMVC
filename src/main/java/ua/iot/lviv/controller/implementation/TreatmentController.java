package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.TreatmentEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.TreatmentService;

public class TreatmentController extends ControllerImpl<TreatmentEntity, Long> {
    final Service<TreatmentEntity, Long> service = new TreatmentService();

    @Override
    public Service<TreatmentEntity, Long> getService() {
        return service;
    }
}