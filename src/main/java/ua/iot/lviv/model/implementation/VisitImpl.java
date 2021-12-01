package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Visit;

import java.time.LocalDateTime;

public class VisitImpl implements Visit {
    private Integer id;
    private LocalDateTime dateTime;
    private Integer clientHasPetId;
    private Integer treatmentId;
    private Integer scheduleId;
    private Integer diagnosisId;

    public VisitImpl(Integer id, LocalDateTime dateTime, Integer clientHasPetId, Integer treatmentId, Integer scheduleId, Integer diagnosisId) {
        this.id = id;
        this.dateTime = dateTime;
        this.clientHasPetId = clientHasPetId;
        this.treatmentId = treatmentId;
        this.scheduleId = scheduleId;
        this.diagnosisId = diagnosisId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public Integer getClientHasPetId() {
        return clientHasPetId;
    }

    @Override
    public Integer getTreatmentId() {
        return treatmentId;
    }

    @Override
    public Integer getScheduleId() {
        return scheduleId;
    }

    @Override
    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void setClientHasPetId(Integer clientHasPetId) {
        this.clientHasPetId = clientHasPetId;
    }

    @Override
    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Override
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    @Override
    public String toString() {
        return "VisitImpl{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", clientHasPetId=" + clientHasPetId +
                ", treatmentId=" + treatmentId +
                ", scheduleId=" + scheduleId +
                ", diagnosisId=" + diagnosisId +
                '}';
    }
}
