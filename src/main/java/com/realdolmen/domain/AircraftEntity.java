package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "aircraft", schema = "realdolmen")
public class AircraftEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "nrFirstClassSeats")
    private int nrFirstClassSeats;
    @Column(name = "nrEconomyClassSeats")
    private int nrEconomyClassSeats;

    @ManyToOne
    private AirlineEntity airlineFK;//Each airline can have many aircrafts

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNrFirstClassSeats() {
        return nrFirstClassSeats;
    }
    public void setNrFirstClassSeats(int nrFirstClassSeats) {
        this.nrFirstClassSeats = nrFirstClassSeats;
    }

    public int getNrEconomyClassSeats() {
        return nrEconomyClassSeats;
    }
    public void setNrEconomyClassSeats(int nrEconomyClassSeats) {
        this.nrEconomyClassSeats = nrEconomyClassSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AircraftEntity that = (AircraftEntity) o;
        return id == that.id &&
                nrFirstClassSeats == that.nrFirstClassSeats &&
                nrEconomyClassSeats == that.nrEconomyClassSeats &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, nrFirstClassSeats, nrEconomyClassSeats);
    }
}
