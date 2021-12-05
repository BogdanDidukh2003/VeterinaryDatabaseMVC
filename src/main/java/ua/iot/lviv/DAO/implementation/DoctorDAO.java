package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.model.DoctorEntity;

public class DoctorDAO extends DAOImpl<DoctorEntity, Long> {

    @Override
    public final Class<DoctorEntity> getClassLiteral() {
        return DoctorEntity.class;
    }

}