package ua.iot.lviv.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.lviv.domain.implementation.ScheduleEntity;
import ua.iot.lviv.repository.ScheduleRepository;


@Service
public class ScheduleService extends ServiceImpl<ScheduleEntity> {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public JpaRepository<ScheduleEntity, Long> getRepository() {
        return scheduleRepository;
    }
}


