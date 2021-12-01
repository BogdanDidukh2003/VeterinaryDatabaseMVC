package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.ClientDAO;
import ua.iot.lviv.model.Client;


public class ClientService extends ServiceImpl<Client> {
    private final DAO<Client, Integer> clientDAO = new ClientDAO();

    @Override
    public DAO<Client, Integer> getDAO() {
        return clientDAO;
    }
}
