package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.ScheduleDAO;
import ua.iot.lviv.model.ScheduleEntity;


public class ScheduleService extends ServiceImpl<ScheduleEntity, Long> {
    private final DAO<ScheduleEntity, Long> clientDAO = new ScheduleDAO();

    @Override
    public DAO<ScheduleEntity, Long> getDAO() {
        return clientDAO;
    }
}


