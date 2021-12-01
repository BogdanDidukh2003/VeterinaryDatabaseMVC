package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.ClientEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.ClientService;

public class ClientController extends ControllerImpl<ClientEntity, Long> {
    final Service<ClientEntity, Long> service = new ClientService();

    @Override
    public Service<ClientEntity, Long> getService() {
        return service;
    }
}
