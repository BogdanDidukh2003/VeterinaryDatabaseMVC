package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.AnimalSpeciesHasTreatment;

public class AnimalSpeciesHasTreatmentImpl implements AnimalSpeciesHasTreatment {
    private Integer id;
    private Integer animalSpeciesId;
    private Integer treatmentId;

    public AnimalSpeciesHasTreatmentImpl(Integer id, Integer AnimalSpeciesId, Integer treatmentId) {
        this.id = id;
        this.animalSpeciesId = AnimalSpeciesId;
        this.treatmentId = treatmentId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getAnimalSpeciesId() {
        return this.animalSpeciesId;
    }

    public void setAnimalSpeciesId(Integer AnimalSpeciesId) {
        this.animalSpeciesId = AnimalSpeciesId;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTreatmentId() {
        return this.treatmentId;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Override
    public String toString() {
        return "AnimalSpeciesHasTreatmentImpl{" +
                "id=" + id +
                ", animalSpeciesId=" + animalSpeciesId +
                ", treatmentId=" + treatmentId +
                '}';
    }
}
