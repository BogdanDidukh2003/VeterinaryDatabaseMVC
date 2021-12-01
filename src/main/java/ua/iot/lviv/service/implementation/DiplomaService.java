package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.DiplomaDAO;
import ua.iot.lviv.model.Diploma;

public class DiplomaService extends ServiceImpl<Diploma> {
    private final DAO<Diploma, Integer> diplomaDAO = new DiplomaDAO();

    @Override
    public DAO<Diploma, Integer> getDAO() {
        return diplomaDAO;
    }
}


