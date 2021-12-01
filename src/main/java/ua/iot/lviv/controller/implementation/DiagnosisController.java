package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Diagnosis;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DiagnosisService;

public class DiagnosisController extends ControllerImpl<Diagnosis> {
    private Service<Diagnosis> diagnosisService = new DiagnosisService();

    @Override
    public Service<Diagnosis> getService() {
        return diagnosisService;
    }
}
