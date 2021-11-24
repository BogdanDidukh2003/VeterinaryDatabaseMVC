package ua.iot.lviv.model;

public interface DoctorHasTreatment extends GeneralModel {
    Integer getDoctorId();

    void setDoctorId(Integer doctorId);

    Integer getTreatmentId();

    void setTreatmentId(Integer treatmentId);
}
