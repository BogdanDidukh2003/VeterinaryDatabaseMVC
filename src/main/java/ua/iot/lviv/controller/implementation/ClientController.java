package ua.iot.lviv.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.lviv.domain.implementation.ClientEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController extends ControllerImp<ClientEntity> {
    @Autowired
    ClientService clientService;

    @Override
    public Service<ClientEntity> getService() {
        return clientService;
    }
}
