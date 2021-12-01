package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.model.TreatmentEntity;

public class TreatmentDAO extends DAOImpl<TreatmentEntity, Long> {

    @Override
    public final Class<TreatmentEntity> getClassLiteral() {
        return TreatmentEntity.class;
    }
}
