package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Schedule;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.ScheduleService;

public class ScheduleController extends ControllerImpl<Schedule> {
    private Service<Schedule> scheduleService = new ScheduleService();

    @Override
    public Service<Schedule> getService() {
        return scheduleService;
    }
}
