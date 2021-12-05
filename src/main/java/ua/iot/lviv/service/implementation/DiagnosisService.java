package ua.iot.lviv.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.lviv.domain.implementation.DiagnosisEntity;
import ua.iot.lviv.repository.DiagnosisRepository;

@Service
public class DiagnosisService extends ServiceImpl<DiagnosisEntity> {
    @Autowired
    DiagnosisRepository diagnosisRepository;

    @Override
    public JpaRepository<DiagnosisEntity, Long> getRepository() {
        return diagnosisRepository;
    }
}

