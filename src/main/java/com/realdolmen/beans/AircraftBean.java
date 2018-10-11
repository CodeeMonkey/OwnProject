package com.realdolmen.beans;

import com.realdolmen.domain.AircraftEntity;
import com.realdolmen.service.AircraftServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AircraftBean {

    @Inject
    AircraftServiceBean aircraftService;

    public AircraftEntity save(AircraftEntity aircraft){ return aircraftService.save(aircraft); }
    public AircraftEntity findById(long aircraftId){ return aircraftService.findById(aircraftId); }
    public List<AircraftEntity> findAll(){ return aircraftService.findAll(); }
    public void remove(long aircraftId){ aircraftService.remove(aircraftId); }

    
}
