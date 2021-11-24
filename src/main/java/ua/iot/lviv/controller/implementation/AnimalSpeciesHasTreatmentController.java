package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.AnimalSpeciesHasTreatment;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.AnimalSpeciesHasTreatmentService;

public class AnimalSpeciesHasTreatmentController extends ControllerImpl<AnimalSpeciesHasTreatment> {
    private Service<AnimalSpeciesHasTreatment> animalSpeciesHasTreatmentService = new AnimalSpeciesHasTreatmentService();

    @Override
    public Service<AnimalSpeciesHasTreatment> getService() {
        return animalSpeciesHasTreatmentService;
    }
}
