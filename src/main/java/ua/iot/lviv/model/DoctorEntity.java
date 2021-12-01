package ua.iot.lviv.model;

import javax.persistence.*;

@Entity
@Table(name = "doctor", schema = "bogdan_didukh", catalog = "")
public class DoctorEntity {
    private Long id;
    private String firstName;
    private String name;
    private String lastName;
    private Integer yearOfBirth;
    private String speciality;

    public DoctorEntity() {
    }

    public DoctorEntity(Long id, String firstName, String name, String lastName, Integer yearOfBirth, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.speciality = speciality;
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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "year_of_birth")
    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Basic
    @Column(name = "speciality")
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorEntity that = (DoctorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (yearOfBirth != null ? !yearOfBirth.equals(that.yearOfBirth) : that.yearOfBirth != null) return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (yearOfBirth != null ? yearOfBirth.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
