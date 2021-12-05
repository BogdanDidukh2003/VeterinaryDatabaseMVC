package ua.iot.lviv.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.lviv.domain.implementation.TreatmentEntity;
import ua.iot.lviv.repository.TreatmentRepository;


@Service
public class TreatmentService extends ServiceImpl<TreatmentEntity> {
    @Autowired
    TreatmentRepository treatmentRepository;

    @Override
    public JpaRepository<TreatmentEntity, Long> getRepository() {
        return treatmentRepository;
    }
}