package com.realdolmen.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bookedflight", schema = "realdolmen")
public class BookedflightEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "pricePaid")
    private Double pricePaid;
    @Column
    private int seatsBooked;
    @Column(name = "cancelled")
    private boolean cancelled;

    @ManyToOne
    private SheduleEntity sheduleFK;//Each schedule can have many booked Flights
    @ManyToMany
    private Set<UserEntity> userFK;//Each booked flight can have many Persons, each Person can have many booked flights


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Double getPricePaid() {
        return pricePaid;
    }
    public void setPricePaid(Double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) { this.seatsBooked = seatsBooked; }

    public boolean isCancelled() { return cancelled; }
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public SheduleEntity getSheduleFK() { return sheduleFK; }
    public void setSheduleFK(SheduleEntity sheduleFK) { this.sheduleFK = sheduleFK; }

    public Set<UserEntity> getUserFK() { return userFK; }
    public void setUserFK(Set<UserEntity> userFK) { this.userFK = userFK; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookedflightEntity that = (BookedflightEntity) o;
        return id == that.id &&
                cancelled == that.cancelled &&
                Objects.equals(pricePaid, that.pricePaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pricePaid, cancelled);
    }
}
