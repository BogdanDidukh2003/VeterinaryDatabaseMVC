package ua.iot.lviv.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.lviv.domain.implementation.PetEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.PetService;

@RestController
@RequestMapping("/pet")
public class PetController extends ControllerImp<PetEntity> {
    @Autowired
    PetService petService;

    @Override
    public Service<PetEntity> getService() {
        return petService;
    }
}