package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.DiagnosisDAO;
import ua.iot.lviv.model.Diagnosis;

public class DiagnosisService extends ServiceImpl<Diagnosis> {
    private final DAO<Diagnosis, Integer> diagnosisDAO = new DiagnosisDAO();

    @Override
    public DAO<Diagnosis, Integer> getDAO() {
        return diagnosisDAO;
    }
}

