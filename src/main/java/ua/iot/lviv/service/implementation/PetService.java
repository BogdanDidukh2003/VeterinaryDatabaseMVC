package ua.iot.lviv.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.lviv.domain.implementation.PetEntity;
import ua.iot.lviv.repository.PetRepository;


@Service
public class PetService extends ServiceImpl<PetEntity> {
    @Autowired
    PetRepository petRepository;

    @Override
    public JpaRepository<PetEntity, Long> getRepository() {
        return petRepository;
    }
}


