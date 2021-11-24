package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.AnimalSpeciesDAO;
import ua.iot.lviv.model.AnimalSpecies;


public class AnimalSpeciesService extends ServiceImpl<AnimalSpecies> {
    private final DAO<AnimalSpecies, Integer> animalSpeciesDAO = new AnimalSpeciesDAO();

    @Override
    public DAO<AnimalSpecies, Integer> getDAO() {
        return animalSpeciesDAO;
    }
}
