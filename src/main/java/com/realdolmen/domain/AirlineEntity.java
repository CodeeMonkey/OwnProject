package com.realdolmen.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "code"})}, name = "airline", schema = "realdolmen")
public class AirlineEntity implements Comparable<AirlineEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Airline code cannot be blank")
    @Size(max = 5, message = "size of Airline code can be maximally ${max} charachters")
    @Column(name = "code", nullable = false, length = 5)
    private String code;

    @NotBlank(message = "Airline name cannot be blank")
    @Size(max = 50, message = "Size of airline name can be maximally ${max} charachters")
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "airline_airport", joinColumns = {@JoinColumn(name = "airline_FK", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "airport_FK", nullable = false)})
    @OrderBy(value = "globalRegionLocation ASC, countryName ASC, cityName ASC, airportName")
    private Set<AirportEntity> airports;

    @OneToMany(mappedBy = "airlineFK", orphanRemoval = true)
    private Set<AircraftEntity> aircrafts;

    @Version
    @Column(name = "version")
    private Integer version;

    @Transient
    private String imageUrl;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<AirportEntity> getAirports() {
        return airports;
    }

    public void setAirports(Set<AirportEntity> airports) {
        this.airports = airports;
    }

    public AirlineEntity() {
        airports = new HashSet<>();
    }

    public AirlineEntity(String code, String name) {
        this(code, name, new HashSet<>());
    }

    public AirlineEntity(String code, String name, Set<AirportEntity> airports) {
        this.code = code;
        this.name = name;
        this.airports = airports;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return code;
    }

    public void setType(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AirportEntity> getAirportFK() {
        return airports;
    }

    public void setAirportFK(Set<AirportEntity> airportFK) {
        this.airports = airportFK;
    }

    public void addAirport(AirportEntity airport) {
        if (airport == null) {
            throw new IllegalArgumentException("No airport entered");
        }
        airports.add(airport);
    }

    public void removeAirport(AirportEntity airport) {
        if (airport == null) {
            throw new IllegalArgumentException("No airport entered");
        }
        airports.remove(airport);
    }

    public Set<AircraftEntity> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(Set<AircraftEntity> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public void removeAllAirports() {
        airports.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AirlineEntity that = (AirlineEntity) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public int compareTo(AirlineEntity thatOne) {
        final int EQUAL = 0;
        if (this == thatOne) {
            return EQUAL;
        }
        int comparisonResult = this.getCode().compareToIgnoreCase(thatOne.getCode());
        if (comparisonResult != EQUAL) {
            return comparisonResult;
        }
        comparisonResult = this.getName().compareToIgnoreCase(thatOne.getName());
        if (comparisonResult != EQUAL) {
            return comparisonResult;
        }
        comparisonResult = this.getType().compareToIgnoreCase(thatOne.getType());
        if (comparisonResult != EQUAL) {
            return comparisonResult;
        }

        for (AirportEntity thisAirport : this.getAirports()) {
            for (AirportEntity thatAirport : thatOne.getAirports()) {
                comparisonResult = thisAirport.getCityCode().compareToIgnoreCase(thatAirport.getCityCode());
                if (comparisonResult != EQUAL) {
                    return comparisonResult;
                }
                comparisonResult = thisAirport.getCityName().compareToIgnoreCase(thatAirport.getCityName());
                if (comparisonResult != EQUAL) {
                    return comparisonResult;
                }
                comparisonResult = thisAirport.getCountryCode().compareToIgnoreCase(thatAirport.getCountryCode());
                if (comparisonResult != EQUAL) {
                    return comparisonResult;
                }
                comparisonResult = thisAirport.getCountryName().compareToIgnoreCase(thatAirport.getCountryName());
                if (comparisonResult != EQUAL) {
                    return comparisonResult;
                }
                comparisonResult = thisAirport.getCityCode().compareToIgnoreCase(thatAirport.getCityCode());
                if (comparisonResult != EQUAL) {
                    return comparisonResult;
                }
                comparisonResult = thisAirport.getGlobalRegionLocation().compareToIgnoreCase(thatAirport.getGlobalRegionLocation());
                if (comparisonResult != EQUAL) {
                    return comparisonResult;
                }
            }
        }
        if (comparisonResult != EQUAL) {
            return comparisonResult;
        }
        return EQUAL;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String getImageUrlFirstCheck() {
        if (this.getName().trim().equals("KLM"))
            return "resources/img/airlines/KL.png";
        else if (this.getName().trim().equals("SWISS"))
            return "resources/img/airlines/LX.png";
        else if (this.getName().trim().equals("Air Belgium"))
            return "resources/img/airlines/airbe.png";
        else if (this.getName().trim().equals("ASL Airlines Belgium"))
            return "resources/img/airlines/AS.png";
        else if (this.getName().trim().equals("Brussels Airlines N.V."))
            return "resources/img/airlines/BA.png";
        else if (this.getName().trim().equals("TUI Airlines Belgium NV"))
            return "resources/img/airlines/tui.png";
        else if (this.getName().trim().equals("Vueling"))
            return "resources/img/airlines/vueling.png";
        else if (this.getName().trim().equals("Ryanair"))
            return "resources/img/airlines/RY.png";
        else if (this.getName().trim().equals("Lufthansa"))
            return "resources/img/airlines/LH.png";
        return "";
    }

    public String getImageUrl() {
        if (this.imageUrl == null || this.imageUrl.isEmpty())
        {
            setImageUrl(getImageUrlFirstCheck());
        }
        return this.imageUrl;
    }

}
