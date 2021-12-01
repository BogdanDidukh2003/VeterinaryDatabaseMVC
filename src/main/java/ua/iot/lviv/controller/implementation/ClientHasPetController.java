package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.ClientHasPet;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.ClientHasPetService;

public class ClientHasPetController extends ControllerImpl<ClientHasPet> {
    private Service<ClientHasPet> clientHasPetService = new ClientHasPetService();

    @Override
    public Service<ClientHasPet> getService() {
        return clientHasPetService;
    }
}
