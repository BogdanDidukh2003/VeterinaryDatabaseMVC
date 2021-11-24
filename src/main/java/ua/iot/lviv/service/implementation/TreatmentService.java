package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.TreatmentDAO;
import ua.iot.lviv.model.Treatment;

public class TreatmentService extends ServiceImpl<Treatment> {
    private final DAO<Treatment, Integer> TreatmentDAO = new TreatmentDAO();

    @Override
    public DAO<Treatment, Integer> getDAO() {
        return TreatmentDAO;
    }
}


