package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.AnimalSpeciesHasTreatmentDAO;
import ua.iot.lviv.model.AnimalSpeciesHasTreatment;

public class AnimalSpeciesHasTreatmentService extends ServiceImpl<AnimalSpeciesHasTreatment> {
    private final DAO<AnimalSpeciesHasTreatment, Integer> animalSpeciesHasTreatmentDAO = new AnimalSpeciesHasTreatmentDAO();

    @Override
    public DAO<AnimalSpeciesHasTreatment, Integer> getDAO() {
        return animalSpeciesHasTreatmentDAO;
    }
}
