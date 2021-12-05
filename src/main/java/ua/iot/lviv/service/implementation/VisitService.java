package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.VisitDAO;
import ua.iot.lviv.model.VisitEntity;

public class VisitService extends ServiceImpl<VisitEntity, Long> {
    private final DAO<VisitEntity, Long> clientDAO = new VisitDAO();

    @Override
    public DAO<VisitEntity, Long> getDAO() {
        return clientDAO;
    }
}


