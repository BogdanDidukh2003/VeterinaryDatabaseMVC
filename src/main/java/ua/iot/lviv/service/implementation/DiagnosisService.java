package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.DiagnosisDAO;
import ua.iot.lviv.model.DiagnosisEntity;

public class DiagnosisService extends ServiceImpl<DiagnosisEntity, Long> {
    private final DAO<DiagnosisEntity, Long> diagnosisDAO = new DiagnosisDAO();

    @Override
    public DAO<DiagnosisEntity, Long> getDAO() {
        return diagnosisDAO;
    }
}

