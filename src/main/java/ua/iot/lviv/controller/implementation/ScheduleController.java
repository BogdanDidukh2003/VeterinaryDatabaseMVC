package ua.iot.lviv.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.lviv.domain.implementation.ScheduleEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController extends ControllerImp<ScheduleEntity> {
    @Autowired
    ScheduleService scheduleService;

    @Override
    public Service<ScheduleEntity> getService() {
        return scheduleService;
    }
}