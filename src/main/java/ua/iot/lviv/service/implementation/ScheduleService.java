package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.ScheduleDAO;
import ua.iot.lviv.model.Schedule;


public class ScheduleService extends ServiceImpl<Schedule> {
    private final DAO<Schedule, Integer> scheduleDAO = new ScheduleDAO();

    @Override
    public DAO<Schedule, Integer> getDAO() {
        return scheduleDAO;
    }
}


