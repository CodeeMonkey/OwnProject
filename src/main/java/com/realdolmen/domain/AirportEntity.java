package com.realdolmen.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "airport", schema = "realdolmen", uniqueConstraints = {@UniqueConstraint(columnNames= {"airportCode", "airportName"})})
@NamedQueries({
        @NamedQuery(name = AirportEntity.IS_REGION, query = "select a from AirportEntity a where a.airportName = :airport"),
        @NamedQuery(name = AirportEntity.GET_REGIONS, query = "select distinct r.globalRegionLocation from AirportEntity r")
})
public class AirportEntity implements Comparable<AirportEntity>{

    public static final String IS_REGION = "AirportEntity_isRegion";
    public static final String GET_REGIONS = "AirportEntity_getRegions";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message = "Airport code cannot be blank")
    @Size(min=3, message = "Airport code must have exactly ${min} characters")
    @Column(name = "airportCode", nullable =false, unique = true, length =3)
    private String airportcode;
    
    @NotBlank(message = "Airport name cannot be blank")
    @Size(max=100, message = "Country name must have maximally ${max} characters")
    @Column(name = "airportName", nullable =false, unique = true, length = 100)
    private String airportName;

    @NotBlank(message = "City code cannot be blank")
    @Size(min=3, max=3, message = "City code must have exactly ${min} characters")
    @Column(name = "cityCode", nullable =false, unique = true,length = 3)
    private String cityCode;
    
    @NotBlank(message = "City name cannot be blank")
    @Column(name = "cityName", nullable =false, length = 255)
    private String cityName;
    
    @NotBlank(message = "Country code cannot be blank")
    @Size(min=2, max=2, message = "City code must have exactly ${min} characters")
    @Column(name = "countryCode", nullable =false, length = 2)
    private String countryCode;
    
    @NotBlank(message = "Country name code cannot be blank")
    @Size(max=50, message = "Country name must have maximally ${max} characters")
    @Column(name = "countryName", nullable =false, length = 50)
    private String countryName;

    @Size(max=50, message = "Region name must have exactly ${max} characters")
    @Column(name = "globalRegionLocation", length = 50)
    private String globalRegionLocation;

    @Column(name = "continent", columnDefinition = "bit(1) default false")
    private boolean continent;
    
	@Version
	@Column(name="version")
	private Integer version;


    public AirportEntity() {
    }

    public AirportEntity(String code, String name, String cityCode, String cityName, String countryCode, String countryName, String globalRegionLocation) {
        this.airportcode = code;
        this.airportName = name;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.globalRegionLocation = globalRegionLocation;
    }

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

    public String getAirportcode() { return airportcode; }
    public void setAirportcode(String airportcode) { this.airportcode = airportcode; }

    public String getAirportName() { return airportName; }
    public void setAirportName(String airportName) { this.airportName = airportName; }

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

    public boolean isContinent() { return continent; }
    public void setContinent(boolean continent) {this.continent = continent; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportEntity that = (AirportEntity) o;
        return Objects.equals(airportcode, that.airportcode) &&
                Objects.equals(airportName, that.airportName) &&
                Objects.equals(cityCode, that.cityCode) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(globalRegionLocation, that.globalRegionLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportcode, airportName, cityCode, cityName, countryCode, countryName, globalRegionLocation);
    }



	@Override
	public int compareTo(AirportEntity thatOne) {
		final int EQUAL= 0;
		if(this==thatOne) {
			return EQUAL;
		}
		int comparisonResult = this.getCode().compareToIgnoreCase(thatOne.getCode());
		if(comparisonResult!=EQUAL) {
			return comparisonResult;
		}
		comparisonResult = this.getAirportName().compareToIgnoreCase(thatOne.getAirportName());
		if(comparisonResult!=EQUAL) {
			return comparisonResult;
		}
		comparisonResult = this.getCityCode().compareToIgnoreCase(thatOne.getCityCode());
		if(comparisonResult!=EQUAL) {
			return comparisonResult;
		}

		comparisonResult = this.getCityName().compareToIgnoreCase(thatOne.getCityName());
		if(comparisonResult!=EQUAL) {
			return comparisonResult;
		}

		comparisonResult = this.getCountryCode().compareToIgnoreCase(thatOne.getCountryCode());
		if(comparisonResult!=EQUAL) {
			return comparisonResult;
		}

		comparisonResult = this.getCountryName().compareToIgnoreCase(thatOne.getCountryCode());
		if(comparisonResult!=EQUAL) {
			return comparisonResult;
		}

		return EQUAL;
	}

    @Override
    public String toString() {
        return "AirportEntity{" +
                "airportcode='" + airportcode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", globalRegionLocation='" + globalRegionLocation + '\'' +
                '}';
    }
}
