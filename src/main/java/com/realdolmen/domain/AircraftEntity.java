package com.realdolmen.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "aircraft", schema = "realdolmen")
public class AircraftEntity implements Comparable<AircraftEntity> {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Aircraft code cannot be blank")
	@Column(name = "code", nullable = false, length = 25)
	private String code;

	@NotBlank(message = "Aircraft name cannot be blank")
	@Size(max = 50, message = "Size of Aircraft name can be maximally ${max} charachters")
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "firstClassSeats", nullable = false)
	private int firstClassSeats;

	@Column(name = "businessClassSeats", nullable = false)
	private int businessSeats;

	@Column(name = "economyClassSeats", nullable = false)
	private int economyClassSeats;

	@ManyToOne
	@JoinColumn(name = "airlineFK_id")
	private AirlineEntity airlineFK;// Each airline can have many aircrafts

	@Version
	@Column(name = "version")
	private Integer version;

    public AircraftEntity() {
    }

	public AircraftEntity(String name, String code, int firstClassSeats, int businessSeats, int economyClassSeats) {
		this.name = name;
		this.code = code;
		this.firstClassSeats = firstClassSeats;
		this.businessSeats = businessSeats;
		this.economyClassSeats = economyClassSeats;
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

    public int getBusinessSeats() { return businessSeats; }
    public void setBusinessSeats(int businessSeats) { this.businessSeats = businessSeats; }

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
        return  getFirstClassSeats() == that.getFirstClassSeats() &&
                getBusinessSeats() == that.getBusinessSeats() &&
                getEconomyClassSeats() == that.getEconomyClassSeats() &&
                Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAirlineFK(), that.getAirlineFK());
    }

	@Override
	public int hashCode() {
		return Objects.hash(getCode(), getName(), getFirstClassSeats(), getEconomyClassSeats(),
				getAirlineFK());
	}

	@Override
	public int compareTo(AircraftEntity thatOne) {
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
		comparisonResult = this.getEconomyClassSeats()-(thatOne.getEconomyClassSeats());
		if (comparisonResult != EQUAL) {
			return comparisonResult;
		}
		comparisonResult = this.getFirstClassSeats()-(thatOne.getFirstClassSeats());
		if (comparisonResult != EQUAL) {
			return comparisonResult;
		}
		return EQUAL;
	}
}
