package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Doctor;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DoctorService;

public class DoctorController extends ControllerImpl<Doctor> {
    private Service<Doctor> doctorService = new DoctorService();

    @Override
    public Service<Doctor> getService() {
        return doctorService;
    }
}
