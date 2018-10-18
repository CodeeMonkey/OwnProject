package com.realdolmen.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "shedule", schema = "realdolmen")
public class ScheduleEntity implements Comparable<ScheduleEntity> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "defaultPrice")
    private Double defaultPrice;
    
    @Column(name = "remainingSeatsEconomy")
    private int remainingSeatsEconomy;

    @Column(name = "remainingSeatsBusiness")
    private int remainingSeatsBusiness;

    @Column(name = "remainingSeatsFirst")
    private int remainingSeatsFirst;
    
    @Column(name = "date")
    private String date;
    
    @Column(name = "departureTime")
    private long departureTime;
    
    @Column(name = "arrivalTime")
    private long arrivalTime;

    @ManyToOne
    private AirportEntity departureAirtportFK;//Each airport can have many scheduled flights
    @ManyToOne
    private AirportEntity arrivalAirtportFK;
    @ManyToOne
    private AircraftEntity aircraftFK;//Each aircraft can have many scheduled flights

	@Version
	@Column(name="version")
	private Integer version;

	@OneToMany
	private List<DiscountEntity> discountList;

	@Transient
    private Double totalPrice;

	@Transient
    private int discountHighest;

    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }

    public Double getDefaultPrice() { return defaultPrice; }
    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public int getRemainingSeatsEconomy() {
        return remainingSeatsEconomy;
    }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public void setRemainingSeatsEconomy(int remainingSeatsEconomy) {this.remainingSeatsEconomy = remainingSeatsEconomy; }

    public int getRemainingSeatsBusiness() {
        return remainingSeatsBusiness;
    }

    public void setRemainingSeatsBusiness(int remainingSeatsBusiness) {this.remainingSeatsBusiness = remainingSeatsBusiness; }

    public int getRemainingSeatsFirst() {
        return remainingSeatsFirst;
    }

    public void setRemainingSeatsFirst(int remainingSeatsFirst) {this.remainingSeatsFirst = remainingSeatsFirst; }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public long getDepartureTime() {return departureTime;}
    public void setDepartureTime(long departureTime) { this.departureTime = departureTime; }

    public long getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(long arrivalTime) { this.arrivalTime = arrivalTime; }

    public int getDiscountHighest() { return discountHighest; }
    public void setDiscountHighest(int discountHighest) { this.discountHighest = discountHighest; }

    public AirportEntity getDepartureAirtportFK() { return departureAirtportFK; }
    public void setDepartureAirtportFK(AirportEntity departureAirtportFK) {
        this.departureAirtportFK = departureAirtportFK;
    }

    public AirportEntity getArrivalAirtportFK() { return arrivalAirtportFK; }
    public void setArrivalAirtportFK(AirportEntity arrivalAirtportFK) {
        this.arrivalAirtportFK = arrivalAirtportFK;
    }

    public AircraftEntity getAircraftFK() { return aircraftFK; }
    public void setAircraftFK(AircraftEntity aircraftFK) { this.aircraftFK = aircraftFK; }

    public List<DiscountEntity> getDiscountList() { return discountList; }
    public void setDiscountList(List<DiscountEntity> discountList) { this.discountList = discountList; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return  remainingSeatsEconomy == that.remainingSeatsEconomy &&
                remainingSeatsBusiness == that.remainingSeatsBusiness &&
                remainingSeatsFirst == that.remainingSeatsFirst &&
                date == that.date &&
                departureTime == that.departureTime &&
                arrivalTime == that.arrivalTime &&
                Objects.equals(defaultPrice, that.defaultPrice);
    }

    /**
     * Calculates the difference in time between 2 epochs times
     * @param departureDate Epoch time
     * @param destinationDate Epoch time
     * @return String time diff
     */
    public String calculateTravelHoursBetweenFlights(Long departureDate, Long destinationDate) {
        long diffInMillies = Math.abs(destinationDate - departureDate);
        long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.SECONDS);

        if (diff % 60 == 0)
        {
            return diff / 60 + "h ";
        }
        if (diff > 60) {
            return diff / 60 + "h " + diff % 60 + "m";
        }

        return diff % 60 + "m";
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultPrice, remainingSeatsEconomy, remainingSeatsBusiness, remainingSeatsFirst, date, departureTime, arrivalTime);
    }

    /**
     * Comparable used to sort Collections
     */
    @Override
    public int compareTo(ScheduleEntity thatOne) {
        final int EQUAL= 0;
        if(this==thatOne) {
            return EQUAL;
        }
        int comparisonResult = Double.compare(this.totalPrice, thatOne.totalPrice);
        if(comparisonResult!=EQUAL) {
            return comparisonResult;
        }

        comparisonResult = Double.compare(this.discountHighest, thatOne.discountHighest);
        if(comparisonResult!=EQUAL) {
            return comparisonResult;
        }

       /* comparisonResult = Double.compare(this.remainingSeats, thatOne.remainingSeats);
        if(comparisonResult!=EQUAL) {
            return comparisonResult;
        }*/

        return EQUAL;
    }
}
