package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "airline", schema = "realdolmen")
public class AirlineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    @ManyToMany
    private Set<AirportEntity> airportFK;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return code;
    }
    public void setType(String type) {
        this.code = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<AirportEntity> getAirportFK() { return airportFK; }
    public void setAirportFK(Set<AirportEntity> airportFK) { this.airportFK = airportFK; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineEntity that = (AirlineEntity) o;
        return id == that.id &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name);
    }
}
