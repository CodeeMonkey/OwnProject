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
    private int firstClassSeats;
    @Column(name = "nrEconomyClassSeats")
    private int economyClassSeats;

    @ManyToOne
    private AirlineEntity airlineFK;//Each airline can have many aircrafts


    public AircraftEntity() {
    }

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

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public void setFirstClassSeats(int firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
    }

    public int getEconomyClassSeats() {
        return economyClassSeats;
    }

    public void setEconomyClassSeats(int economyClassSeats) {
        this.economyClassSeats = economyClassSeats;
    }

    public AirlineEntity getAirlineFK() {
        return airlineFK;
    }

    public void setAirlineFK(AirlineEntity airlineFK) {
        this.airlineFK = airlineFK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AircraftEntity)) return false;
        AircraftEntity that = (AircraftEntity) o;
        return getId() == that.getId() &&
                getFirstClassSeats() == that.getFirstClassSeats() &&
                getEconomyClassSeats() == that.getEconomyClassSeats() &&
                Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAirlineFK(), that.getAirlineFK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName(), getFirstClassSeats(), getEconomyClassSeats(), getAirlineFK());
    }
}
