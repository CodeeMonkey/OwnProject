package com.realdolmen.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "discount", schema = "realdolmen")
public class DiscountEntity {

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
    @ManyToOne
    private SheduleEntity sheduleFK;//Each schedule can have many discounts


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getMinNumOfSeatsReserved() { return minNumOfSeatsReserved; }
    public void setMinNumOfSeatsReserved(int minNumOfSeatsReserved) {
        this.minNumOfSeatsReserved = minNumOfSeatsReserved;
    }

    public AirlineEntity getAirlineFK() { return airlineFK; }
    public void setAirlineFK(AirlineEntity airlineFK) { this.airlineFK = airlineFK; }

    public SheduleEntity getSheduleFK() { return sheduleFK; }
    public void setSheduleFK(SheduleEntity sheduleFK) { this.sheduleFK = sheduleFK; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountEntity that = (DiscountEntity) o;
        return id == that.id &&
                discountPercentage == that.discountPercentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discountPercentage);
    }
}
