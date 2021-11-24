package ua.iot.lviv.model;

public interface AnimalSpeciesHasTreatment extends GeneralModel {
    Integer getAnimalSpeciesId();

    void setAnimalSpeciesId(Integer AnimalSpeciesId);

    Integer getTreatmentId();

    void setTreatmentId(Integer treatmentId);
}
