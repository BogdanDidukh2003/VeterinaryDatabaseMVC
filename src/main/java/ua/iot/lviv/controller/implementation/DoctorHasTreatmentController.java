package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.DoctorHasTreatment;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DoctorHasTreatmentService;

public class DoctorHasTreatmentController extends ControllerImpl<DoctorHasTreatment> {
    private Service<DoctorHasTreatment> doctorHasTreatmentService = new DoctorHasTreatmentService();

    @Override
    public Service<DoctorHasTreatment> getService() {
        return doctorHasTreatmentService;
    }
}
