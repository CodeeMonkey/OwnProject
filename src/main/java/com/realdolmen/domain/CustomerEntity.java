package com.realdolmen.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@DiscriminatorValue("C")
@Table(name = "user", schema = "realdolmen")
public class CustomerEntity extends UserEntity {

    public CustomerEntity() {
    }

    public CustomerEntity(String firstName, String lastName, String country, String mobilePhone, Date birthDate, LoginEntity login) {
        super(firstName, lastName, country, mobilePhone, birthDate, login);
    }
}