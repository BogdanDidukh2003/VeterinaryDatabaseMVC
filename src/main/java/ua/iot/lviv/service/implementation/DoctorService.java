package ua.iot.lviv.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.lviv.domain.implementation.DoctorEntity;
import ua.iot.lviv.repository.DoctorRepository;


@Service
public class DoctorService extends ServiceImpl<DoctorEntity> {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public JpaRepository<DoctorEntity, Long> getRepository() {
        return doctorRepository;
    }
}


