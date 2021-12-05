package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.TreatmentDAO;
import ua.iot.lviv.model.TreatmentEntity;


public class TreatmentService extends ServiceImpl<TreatmentEntity, Long> {
    private final DAO<TreatmentEntity, Long> clientDAO = new TreatmentDAO();

    @Override
    public DAO<TreatmentEntity, Long> getDAO() {
        return clientDAO;
    }
}

