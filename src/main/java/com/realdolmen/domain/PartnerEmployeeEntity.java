package com.realdolmen.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("P")
@Table(name = "user", schema = "realdolmen")
public class PartnerEmployeeEntity extends UserEntity {

    @ManyToOne
    private AirlineEntity airline;

    public AirlineEntity getAirline() {
        return airline;
    }
    public void setAirline(AirlineEntity airline) {
        this.airline = airline;
    }

}
