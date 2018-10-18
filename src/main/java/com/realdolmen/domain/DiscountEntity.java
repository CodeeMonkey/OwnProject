package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "discount", schema = "realdolmen")
@NamedQueries({
        @NamedQuery(name = DiscountEntity.SEARCH_AVAILABLE_DISCOUNTS,
                query = "select d from DiscountEntity d where (d.airlineFK = :airlineFK and d.sheduleFK = :shefuleFK) " +
                        "OR d.airlineFK = :airlineFK and d.sheduleFK = null"),
        @NamedQuery(name = DiscountEntity.SEARCH_ALL_DISCOUNTS,
                query = "select d from DiscountEntity d ")
})
public class DiscountEntity {

    public final static String SEARCH_ALL_DISCOUNTS = "DiscountEntity.Query.ALL";
    public final static String SEARCH_AVAILABLE_DISCOUNTS = "DiscountEntity.Query";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "discountPercentage")
    private int discountPercentage;
    @Column()
    private int minNumOfSeatsReserved;

    @ManyToOne
    private AirlineEntity airlineFK;//Each airline can have many discounts
    @ManyToOne(optional = true)
    private ScheduleEntity sheduleFK;//Each schedule can have many discounts

	@Version
	@Column(name="version")
	private Integer version;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getMinNumOfSeatsReserved() { return minNumOfSeatsReserved; }
    public void setMinNumOfSeatsReserved(int minNumOfSeatsReserved) {
        this.minNumOfSeatsReserved = minNumOfSeatsReserved;
    }

    public AirlineEntity getAirlineFK() { return airlineFK; }
    public void setAirlineFK(AirlineEntity airlineFK) { this.airlineFK = airlineFK; }

    public ScheduleEntity getSheduleFK() { return sheduleFK; }
    public void setSheduleFK(ScheduleEntity sheduleFK) { this.sheduleFK = sheduleFK; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountEntity)) return false;
        DiscountEntity that = (DiscountEntity) o;
        return getDiscountPercentage() == that.getDiscountPercentage() &&
                getMinNumOfSeatsReserved() == that.getMinNumOfSeatsReserved();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscountPercentage(), getMinNumOfSeatsReserved());
    }
}
