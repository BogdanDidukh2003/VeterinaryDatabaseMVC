package ua.iot.lviv.domain.implementation;

import ua.iot.lviv.domain.Entity;

import javax.persistence.*;
import java.sql.Date;

@javax.persistence.Entity
@Table(name = "pet", schema = "bogdan_didukh", catalog = "")
public class PetEntity implements Entity {
    private Long id;
    private String animalSpecies;
    private String name;
    private Integer weightKg;
    private Integer lengthCm;
    private Date dateOfBirth;
    private ClientEntity clientByClientId;

    public PetEntity() {
    }

    public PetEntity(Long id, String animalSpecies, String name, Integer weightKg, Integer lengthCm, Date dateOfBirth, ClientEntity clientByClientId) {
        this.id = id;
        this.animalSpecies = animalSpecies;
        this.name = name;
        this.weightKg = weightKg;
        this.lengthCm = lengthCm;
        this.dateOfBirth = dateOfBirth;
        this.clientByClientId = clientByClientId;
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
    @Column(name = "animal_species")
    public String getAnimalSpecies() {
        return animalSpecies;
    }

    public void setAnimalSpecies(String animalSpecies) {
        this.animalSpecies = animalSpecies;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "weight_kg")
    public Integer getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    @Basic
    @Column(name = "length_cm")
    public Integer getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(Integer lengthCm) {
        this.lengthCm = lengthCm;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetEntity petEntity = (PetEntity) o;

        if (id != null ? !id.equals(petEntity.id) : petEntity.id != null) return false;
        if (animalSpecies != null ? !animalSpecies.equals(petEntity.animalSpecies) : petEntity.animalSpecies != null)
            return false;
        if (name != null ? !name.equals(petEntity.name) : petEntity.name != null) return false;
        if (weightKg != null ? !weightKg.equals(petEntity.weightKg) : petEntity.weightKg != null) return false;
        if (lengthCm != null ? !lengthCm.equals(petEntity.lengthCm) : petEntity.lengthCm != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(petEntity.dateOfBirth) : petEntity.dateOfBirth != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (animalSpecies != null ? animalSpecies.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (weightKg != null ? weightKg.hashCode() : 0);
        result = 31 * result + (lengthCm != null ? lengthCm.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "id=" + id +
                ", animalSpecies='" + animalSpecies + '\'' +
                ", name='" + name + '\'' +
                ", weightKg=" + weightKg +
                ", lengthCm=" + lengthCm +
                ", dateOfBirth=" + dateOfBirth +
                ", clientByClientId=" + clientByClientId +
                '}';
    }
}
