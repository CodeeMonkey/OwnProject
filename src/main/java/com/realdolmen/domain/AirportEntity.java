package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "airport", schema = "realdolmen")
public class AirportEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "cityCode")
    private String cityCode;
    @Column(name = "cityName")
    private String cityName;
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "countryName")
    private String countryName;
    @Column(name = "globalRegionLocation")
    private String globalRegionLocation;

    @ManyToMany
    private Set<AirlineEntity> airlineFK;

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

    public String getCityCode() {
        return cityCode;
    }
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getGlobalRegionLocation() {
        return globalRegionLocation;
    }
    public void setGlobalRegionLocation(String globalRegionLocation) {
        this.globalRegionLocation = globalRegionLocation;
    }

    public Set<AirlineEntity> getAirlineFK() { return airlineFK; }
    public void setAirlineFK(Set<AirlineEntity> airlineFK) { this.airlineFK = airlineFK; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportEntity that = (AirportEntity) o;
        return id == that.id &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(cityCode, that.cityCode) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(globalRegionLocation, that.globalRegionLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, cityCode, cityName, countryCode, countryName, globalRegionLocation);
    }
}
