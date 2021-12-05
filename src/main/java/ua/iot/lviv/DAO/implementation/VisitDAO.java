package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.model.VisitEntity;

public class VisitDAO extends DAOImpl<VisitEntity, Long> {

    @Override
    public final Class<VisitEntity> getClassLiteral() {
        return VisitEntity.class;
    }
}