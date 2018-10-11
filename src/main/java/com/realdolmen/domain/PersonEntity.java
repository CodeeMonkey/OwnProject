package com.realdolmen.domain;

import com.realdolmen.utils.DateUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person", schema = "realdolmen")
@NamedQuery(name = "find all people", query = "select p from PersonEntity p order by p.lastName, p.firstName")
public class PersonEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Size(max = 200)
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Column(name = "country", length = 50)
    private String country;
    @Column(name = "mobilePhone", length = 50)
    private String mobilePhone;
    @Past
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Transient
    private long age;
    @Version
    private int version;

    @OneToOne
    private LoginEntity login;


    public long getId() {  return id; }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public long getAge() { return age; }
    public void setAge(long age) { this.age = age; }

    public void setVersion(int version) { this.version = version; }
    public LoginEntity getLogin() { return login; }

    public void setLogin(LoginEntity login) { this.login = login; }



    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        initializeAge();
    }

    public int getVersion() {
        return version;
    }

    public String name() {
        return firstName + " " + lastName;
    }

    public Date getBirthDate() { return birthDate; }

    @PostLoad
    public void initializeAge() {
        this.age = DateUtils.yearsFrom(birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(country, that.country) &&
                Objects.equals(mobilePhone, that.mobilePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, country, mobilePhone);
    }
}
