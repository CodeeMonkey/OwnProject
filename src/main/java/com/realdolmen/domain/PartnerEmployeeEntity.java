package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "partneremployee", schema = "realdolmen")
public class PartnerEmployeeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private PersonEntity person;
    @ManyToOne
    private AirlineEntity airline;

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

    public AirlineEntity getAirline() {
        return airline;
    }
    public void setAirline(AirlineEntity airline) {
        this.airline = airline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartnerEmployeeEntity that = (PartnerEmployeeEntity) o;
        return Objects.equals(person, that.person) &&
                Objects.equals(airline, that.airline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), person, airline);
    }
}
