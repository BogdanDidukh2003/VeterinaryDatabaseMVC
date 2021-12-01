package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.ClientDAO;
import ua.iot.lviv.model.ClientEntity;


public class ClientService extends ServiceImpl<ClientEntity, Long> {
    private final DAO<ClientEntity, Long> clientDAO = new ClientDAO();

    @Override
    public DAO<ClientEntity, Long> getDAO() {
        return clientDAO;
    }
}
