package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.VisitDAO;
import ua.iot.lviv.model.Visit;

public class VisitService extends ServiceImpl<Visit> {
    private final DAO<Visit, Integer> visitDAO = new VisitDAO();

    @Override
    public DAO<Visit, Integer> getDAO() {
        return visitDAO;
    }
}


