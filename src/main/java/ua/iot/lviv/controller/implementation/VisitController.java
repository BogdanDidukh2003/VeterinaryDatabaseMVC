package ua.iot.lviv.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.lviv.domain.implementation.VisitEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.VisitService;

@RestController
@RequestMapping("/visit")
public class VisitController extends ControllerImp<VisitEntity> {
    @Autowired
    VisitService visitService;

    @Override
    public Service<VisitEntity> getService() {
        return visitService;
    }
}