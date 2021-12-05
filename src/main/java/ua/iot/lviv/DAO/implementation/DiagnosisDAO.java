package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.model.DiagnosisEntity;

public class DiagnosisDAO extends DAOImpl<DiagnosisEntity, Long> {

    @Override
    public final Class<DiagnosisEntity> getClassLiteral() {
        return DiagnosisEntity.class;
    }

}