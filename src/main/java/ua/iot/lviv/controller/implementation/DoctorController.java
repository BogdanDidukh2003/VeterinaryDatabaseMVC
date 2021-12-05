package ua.iot.lviv.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.lviv.domain.implementation.DoctorEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends ControllerImp<DoctorEntity> {
    @Autowired
    DoctorService doctorService;

    @Override
    public Service<DoctorEntity> getService() {
        return doctorService;
    }
}