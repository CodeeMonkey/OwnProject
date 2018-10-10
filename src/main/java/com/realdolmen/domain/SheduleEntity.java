package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shedule", schema = "realdolmen")
public class SheduleEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "defaultPrice")
    private Double defaultPrice;
    @Column(name = "remainingSeats")
    private int remainingSeats;
    @Column(name = "date")
    private int date;
    @Column(name = "departureTime")
    private int departureTime;
    @Column(name = "arrivalTime")
    private int arrivalTime;

    @ManyToOne
    private AirportEntity departureAirtportFK;//Each airport can have many scheduled flights
    @ManyToOne
    private AirportEntity arrivalAirtportFK;
    @ManyToOne
    private AircraftEntity aircraftFK;//Each aircraft can have many scheduled flights


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Double getDefaultPrice() {
        return defaultPrice;
    }
    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }
    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }

    public int getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheduleEntity that = (SheduleEntity) o;
        return id == that.id &&
                remainingSeats == that.remainingSeats &&
                date == that.date &&
                departureTime == that.departureTime &&
                arrivalTime == that.arrivalTime &&
                Objects.equals(defaultPrice, that.defaultPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, defaultPrice, remainingSeats, date, departureTime, arrivalTime);
    }
}
