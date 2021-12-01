package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.DiagnosisEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DiagnosisService;

public class DiagnosisController extends ControllerImpl<DiagnosisEntity, Long> {
    final Service<DiagnosisEntity, Long> service = new DiagnosisService();

    @Override
    public Service<DiagnosisEntity, Long> getService() {
        return service;
    }
}
