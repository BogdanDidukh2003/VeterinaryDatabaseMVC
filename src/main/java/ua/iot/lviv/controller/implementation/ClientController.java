package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Client;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.ClientService;

public class ClientController extends ControllerImpl<Client> {
    private Service<Client> clientService = new ClientService();

    @Override
    public Service<Client> getService() {
        return clientService;
    }
}
