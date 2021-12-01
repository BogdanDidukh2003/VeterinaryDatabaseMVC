package ua.iot.lviv.controller.implementation;


import ua.iot.lviv.model.AnimalSpecies;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.AnimalSpeciesService;

public class AnimalSpeciesController extends ControllerImpl<AnimalSpecies> {
    private Service<AnimalSpecies> animalSpeciesService = new AnimalSpeciesService();

    @Override
    public Service<AnimalSpecies> getService() {
        return animalSpeciesService;
    }
}
