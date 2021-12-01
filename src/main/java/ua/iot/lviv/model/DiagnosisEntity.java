package ua.iot.lviv.model;

import javax.persistence.*;

@Entity
@Table(name = "diagnosis", schema = "bogdan_didukh", catalog = "")
public class DiagnosisEntity {
    private Long id;
    private String diagnosis;
    private String treatment;

    public DiagnosisEntity() {
    }

    public DiagnosisEntity(Long id, String diagnosis, String treatment) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
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
    @Column(name = "diagnosis")
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "treatment")
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiagnosisEntity that = (DiagnosisEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (treatment != null ? !treatment.equals(that.treatment) : that.treatment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (treatment != null ? treatment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DiagnosisEntity{" +
                "id=" + id +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
