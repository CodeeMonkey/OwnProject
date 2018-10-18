package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class PriceChangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "type")
    private String type; //SEASON, MONTH, WEEK, NIGHT
    @Column(name = "startDate")
    private int startdate;
    @Column(name = "endDate")
    private int enddate;
    @Column(name = "changeRate")
    private int changeRate;

    @ManyToOne
    private AirlineEntity airlineFK;//Each airline can have many priceChange Overrides.


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type;  }

    public int getStartdate() { return startdate;  }
    public void setStartdate(int startdate) { this.startdate = startdate; }

    public int getEnddate() { return enddate;  }
    public void setEnddate(int enddate) { this.enddate = enddate; }

    public int getChangeRate() { return changeRate; }
    public void setChangeRate(int changeRate) { this.changeRate = changeRate; }

    public AirlineEntity getAirlineFK() { return airlineFK; }
    public void setAirlineFK(AirlineEntity airlineFK) { this.airlineFK = airlineFK; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceChangeEntity)) return false;
        PriceChangeEntity that = (PriceChangeEntity) o;
        return  getStartdate() == that.getStartdate() &&
                getEnddate() == that.getEnddate() &&
                getChangeRate() == that.getChangeRate() &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getAirlineFK(), that.getAirlineFK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getStartdate(), getEnddate(), getChangeRate(), getAirlineFK());
    }
}
