package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.DoctorDAO;
import ua.iot.lviv.model.DoctorEntity;

public class DoctorService extends ServiceImpl<DoctorEntity, Long> {
    private final DAO<DoctorEntity, Long> doctorDAO = new DoctorDAO();

    @Override
    public DAO<DoctorEntity, Long> getDAO() {
        return doctorDAO;
    }
}


