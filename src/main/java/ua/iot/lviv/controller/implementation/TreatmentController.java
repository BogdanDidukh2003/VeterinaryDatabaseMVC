package ua.iot.lviv.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.lviv.domain.implementation.TreatmentEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.TreatmentService;

@RestController
@RequestMapping("/service")
public class TreatmentController extends ControllerImp<TreatmentEntity> {
    @Autowired
    TreatmentService treatmentService;

    @Override
    public Service<TreatmentEntity> getService() {
        return treatmentService;
    }
}