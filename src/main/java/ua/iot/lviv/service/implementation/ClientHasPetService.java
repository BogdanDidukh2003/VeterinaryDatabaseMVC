package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.ClientHasPetDAO;
import ua.iot.lviv.model.ClientHasPet;


public class ClientHasPetService extends ServiceImpl<ClientHasPet> {
    private final DAO<ClientHasPet, Integer> clientHasPetDAO = new ClientHasPetDAO();

    @Override
    public DAO<ClientHasPet, Integer> getDAO() {
        return clientHasPetDAO;
    }
}
