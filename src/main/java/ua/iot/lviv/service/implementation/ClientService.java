package ua.iot.lviv.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.lviv.domain.implementation.ClientEntity;
import ua.iot.lviv.repository.ClientRepository;

@Service
public class ClientService extends ServiceImpl<ClientEntity> {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public JpaRepository<ClientEntity, Long> getRepository() {
        return clientRepository;
    }
}
