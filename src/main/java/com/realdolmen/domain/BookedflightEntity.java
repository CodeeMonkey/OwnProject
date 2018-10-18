package com.realdolmen.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bookedflight", schema = "realdolmen")
@NamedQueries({
        @NamedQuery(name = BookedflightEntity.SEARCH_ALL_BOOKEDFLIGHTS,
                query = "select b from BookedflightEntity b where b.userFK.id = :userId")
})
public class BookedflightEntity {
    public final static String SEARCH_ALL_BOOKEDFLIGHTS= "BookedFlight.Query.ALL";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pricePaid")
    private Double pricePaid;

    @Column
    private int seatsBooked;

    @NotEmpty
    @Column(name = "payMethod")
    private String payMethod;

    @Column(name = "paymentStatus")
    private String payStatus;

    @Column(name = "cancelled")
    private boolean cancelled;

    @ManyToOne
    private ScheduleEntity sheduleFK;//Each schedule can have many booked Flights

    @ManyToOne
    private CustomerEntity userFK;//Each booked flight can have many Persons, each Person can have many booked flights

    @Version
	@Column(name="version")
	private Integer version;

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

    public ScheduleEntity getSheduleFK() { return sheduleFK; }
    public void setSheduleFK(ScheduleEntity sheduleFK) { this.sheduleFK = sheduleFK; }

    public CustomerEntity getUserFK() { return userFK; }
    public void setUserFK(CustomerEntity userFK) { this.userFK = userFK; }

    public String getPayMethod() { return payMethod; }
    public void setPayMethod(String payMethod) { this.payMethod = payMethod; }

    public String getPayStatus() { return payStatus; }
    public void setPayStatus(String payStatus) { this.payStatus = payStatus; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookedflightEntity that = (BookedflightEntity) o;
        return  cancelled == that.cancelled &&
                Objects.equals(pricePaid, that.pricePaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePaid, cancelled);
    }
}
