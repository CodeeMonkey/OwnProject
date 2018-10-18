package com.realdolmen.domain;

import com.realdolmen.utils.DateUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("U")
@Table(name = "user", schema = "realdolmen")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First Name cannot be blank")
    @Size(max = 50)
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Size(max = 50, message = "Lastname can be maximally ${max} characters")
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Size(max = 30, message = "Country name can be maximally ${max} characters")
    @Column(name = "country", length = 30)
    private String country;

    @Size(max = 20, message = "Mobile phone name can be maximally ${max} characters")
    @Column(name = "mobilePhone", length = 20)
    private String mobilePhone;
    @Past
    @NotNull(message = "Birthdate must be filled out")
    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

    @Transient
    private long age;

    @Version
    private int version;

    @OneToOne
    @JoinColumn(name = "login_id")
    private LoginEntity login;

    public UserEntity(){}

    public UserEntity(String firstName, String lastName, String country, String mobilePhone, Date birthDate, LoginEntity login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.mobilePhone = mobilePhone;
        this.birthDate = birthDate;
        this.age = age;
        this.version = version;
        this.login = login;
    }

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
        UserEntity that = (UserEntity) o;
        return  Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(country, that.country) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(mobilePhone, that.mobilePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate, country, mobilePhone);
    }

}
