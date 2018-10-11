package com.realdolmen.beans;

import com.realdolmen.domain.AirlineEntity;
import com.realdolmen.service.AirlineServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AirlineBean {

    @Inject
    AirlineServiceBean airlineService;

    public AirlineEntity save(AirlineEntity airline){ return airlineService.save(airline); }
    public AirlineEntity findById(long airlineId){ return airlineService.findById(airlineId); }
    public List<AirlineEntity> findAll(){ return airlineService.findAll(); }
    public void remove(long airlineId){ airlineService.remove(airlineId); }


}
