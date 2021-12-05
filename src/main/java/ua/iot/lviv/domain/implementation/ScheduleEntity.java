package ua.iot.lviv.domain.implementation;

import ua.iot.lviv.domain.Entity;

import javax.persistence.*;
import java.sql.Time;

@javax.persistence.Entity
@Table(name = "schedule", schema = "bogdan_didukh", catalog = "")
public class ScheduleEntity implements Entity {
    private Long id;
    private Time timeStart;
    private Time timeEnd;
    private String weekDay;
    private DoctorEntity doctorByDoctorId;

    public ScheduleEntity() {
    }

    public ScheduleEntity(Long id, Time timeStart, Time timeEnd, String weekDay, DoctorEntity doctorByDoctorId) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.weekDay = weekDay;
        this.doctorByDoctorId = doctorByDoctorId;
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time_start")
    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    @Basic
    @Column(name = "time_end")
    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Basic
    @Column(name = "week_day")
    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntity that = (ScheduleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timeStart != null ? !timeStart.equals(that.timeStart) : that.timeStart != null) return false;
        if (timeEnd != null ? !timeEnd.equals(that.timeEnd) : that.timeEnd != null) return false;
        if (weekDay != null ? !weekDay.equals(that.weekDay) : that.weekDay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timeStart != null ? timeStart.hashCode() : 0);
        result = 31 * result + (timeEnd != null ? timeEnd.hashCode() : 0);
        result = 31 * result + (weekDay != null ? weekDay.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    public DoctorEntity getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorByDoctorId(DoctorEntity doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }

    @Override
    public String toString() {
        return "ScheduleEntity{" +
                "id=" + id +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", weekDay='" + weekDay + '\'' +
                ", doctorByDoctorId=" + doctorByDoctorId +
                '}';
    }
}
