package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "realdolmen")
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private PersonEntity person;


    public long getId() {  return id; }
    public void setId(long id) {
        this.id = id;
    }

    public PersonEntity getPerson() {
        return person;
    }
    public void setPerson(PersonEntity login) {
        this.person = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return
                Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), person);
    }
}
