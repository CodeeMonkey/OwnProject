package com.realdolmen.beans;

import com.realdolmen.domain.AirportEntity;
import com.realdolmen.service.AirportServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AirportBean {

    @Inject
    AirportServiceBean airportService;

    public AirportEntity save(AirportEntity airport){ return airportService.save(airport); }
    public AirportEntity findById(long airportId){ return airportService.findById(airportId); }
    public List<AirportEntity> findAll(){
        return airportService.findAll();
    }
    public void remove(long airportId){
        airportService.remove(airportId);
    }


}
