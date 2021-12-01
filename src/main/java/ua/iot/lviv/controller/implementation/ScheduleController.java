package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.ScheduleEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.ScheduleService;

public class ScheduleController extends ControllerImpl<ScheduleEntity, Long> {
    final Service<ScheduleEntity, Long> service = new ScheduleService();

    @Override
    public Service<ScheduleEntity, Long> getService() {
        return service;
    }
}
