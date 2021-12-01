package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.model.ScheduleEntity;

public class ScheduleDAO extends DAOImpl<ScheduleEntity, Long> {

    @Override
    public final Class<ScheduleEntity> getClassLiteral() {
        return ScheduleEntity.class;
    }
}