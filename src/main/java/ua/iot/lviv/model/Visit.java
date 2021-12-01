package ua.iot.lviv.model;

import java.time.LocalDateTime;

public interface Visit extends GeneralModel {
    LocalDateTime getDateTime();

    void setDateTime(LocalDateTime dateTime);

    Integer getClientHasPetId();

    void setClientHasPetId(Integer clientHasPetId);

    Integer getTreatmentId();

    void setTreatmentId(Integer treatmentId);

    Integer getScheduleId();

    void setScheduleId(Integer scheduleId);

    Integer getDiagnosisId();

    void setDiagnosisId(Integer diagnosisId);
}
