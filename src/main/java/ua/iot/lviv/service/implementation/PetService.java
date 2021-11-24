package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.PetDAO;
import ua.iot.lviv.model.Pet;

public class PetService extends ServiceImpl<Pet> {
    private final DAO<Pet, Integer> petDAO = new PetDAO();

    @Override
    public DAO<Pet, Integer> getDAO() {
        return petDAO;
    }
}



