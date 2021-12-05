package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.model.PetEntity;

public class PetDAO extends DAOImpl<PetEntity, Long> {

    @Override
    public final Class<PetEntity> getClassLiteral() {
        return PetEntity.class;
    }
}
