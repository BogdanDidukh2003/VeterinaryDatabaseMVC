package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.DoctorHasTreatment;

public class DoctorHasTreatmentImpl implements DoctorHasTreatment {
    private Integer id;
    private Integer doctorId;
    private Integer treatmentId;

    public DoctorHasTreatmentImpl(Integer id, Integer doctorId, Integer treatmentId) {
        this.id = id;
        this.doctorId = doctorId;
        this.treatmentId = treatmentId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getDoctorId() {
        return doctorId;
    }

    @Override
    public Integer getTreatmentId() {
        return treatmentId;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Override
    public String toString() {
        return "DoctorHasTreatmentImpl{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", treatmentId=" + treatmentId +
                '}';
    }
}
