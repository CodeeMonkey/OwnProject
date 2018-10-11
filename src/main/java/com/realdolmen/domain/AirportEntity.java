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
    @Column(name = "airportCode")
    private String airportcode;
    @Column(name = "airportName")
    private String airportName;
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

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return airportcode;
    }
    public void setCode(String code) {
        this.airportcode = code;
    }

    public String getName() {
        return airportName;
    }
    public void setName(String name) {
        this.airportName = name;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportEntity that = (AirportEntity) o;
        return id == that.id &&
                Objects.equals(airportcode, that.airportcode) &&
                Objects.equals(airportName, that.airportName) &&
                Objects.equals(cityCode, that.cityCode) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(globalRegionLocation, that.globalRegionLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airportcode, airportName, cityCode, cityName, countryCode, countryName, globalRegionLocation);
    }
}
