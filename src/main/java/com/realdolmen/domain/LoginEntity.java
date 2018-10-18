package com.realdolmen.domain;


import com.realdolmen.validations.ValidEmail;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "login", schema = "realdolmen")
@NamedQueries({
        @NamedQuery(name = LoginEntity.SEARCH_BY_EMAIL,
                    query = "select l from LoginEntity l where lower(l.email) = lower(:email)"),
})
public class LoginEntity {
    public final static String SEARCH_BY_EMAIL = "LoginEntity.Query";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    @ValidEmail
    @Column(name = "email", nullable = false, length=100)
    private String email;

    @Column(name = "password", nullable = false, length=300)
    private String password;
    @Column(name = "role")
    private int role;

    public LoginEntity(){}

    public LoginEntity(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = 0;
    }

    @OneToOne(mappedBy = "login")
    private UserEntity user;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() { return role; }
    public void setRole(int role) { this.role = role; }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginEntity that = (LoginEntity) o;
        return  Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}