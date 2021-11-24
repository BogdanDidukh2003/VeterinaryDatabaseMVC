package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Pet;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.PetService;

public class PetController extends ControllerImpl<Pet> {
    private Service<Pet> petService = new PetService();

    @Override
    public Service<Pet> getService() {
        return petService;
    }
}
