package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.implementation.PetDAO;
import ua.iot.lviv.model.PetEntity;

public class PetService extends ServiceImpl<PetEntity, Long> {
    private final ua.iot.lviv.DAO.DAO<PetEntity, Long> DAO = new PetDAO();

    @Override
    public ua.iot.lviv.DAO.DAO<PetEntity, Long> getDAO() {
        return DAO;
    }
}


