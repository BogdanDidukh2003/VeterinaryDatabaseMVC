package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.DoctorDAO;
import ua.iot.lviv.model.Doctor;

public class DoctorService extends ServiceImpl<Doctor> {
    private final DAO<Doctor, Integer> doctorDAO = new DoctorDAO();

    @Override
    public DAO<Doctor, Integer> getDAO() {
        return doctorDAO;
    }
}


