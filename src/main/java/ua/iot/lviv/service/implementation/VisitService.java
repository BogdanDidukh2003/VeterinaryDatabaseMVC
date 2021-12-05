package ua.iot.lviv.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.lviv.domain.implementation.VisitEntity;
import ua.iot.lviv.repository.VisitRepository;


@Service
public class VisitService extends ServiceImpl<VisitEntity> {
    @Autowired
    VisitRepository visitRepository;

    @Override
    public JpaRepository<VisitEntity, Long> getRepository() {
        return visitRepository;
    }
}