package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.DAO;
import ua.iot.lviv.DAO.implementation.DoctorHasTreatmentDAO;
import ua.iot.lviv.model.DoctorHasTreatment;

public class DoctorHasTreatmentService extends ServiceImpl<DoctorHasTreatment> {
    private final DAO<DoctorHasTreatment, Integer> doctorHasTreatmentDAO = new DoctorHasTreatmentDAO();

    @Override
    public DAO<DoctorHasTreatment, Integer> getDAO() {
        return doctorHasTreatmentDAO;
    }
}


