package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.model.ClientEntity;

public class ClientDAO extends DAOImpl<ClientEntity, Long> {

    @Override
    public final Class<ClientEntity> getClassLiteral() {
        return ClientEntity.class;
    }
}
