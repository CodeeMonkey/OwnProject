package com.realdolmen.service;

import com.realdolmen.domain.AircraftEntity;
import com.realdolmen.repository.AircraftRepository;
import com.realdolmen.service.remotes.AircraftServiceRemote;
import com.realdolmen.service.remotes.AirportServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class AircraftServiceBean implements AircraftServiceRemote {

    @EJB
    AircraftRepository aircraftRepository;

    @Override
    public AircraftEntity save(AircraftEntity aircraft) { return aircraftRepository.save(aircraft); }

    @Override
    public AircraftEntity findById(Long id) { return aircraftRepository.findById(id); }

    @Override
    public List<AircraftEntity> findAll() { return aircraftRepository.findAll(); }

    @Override
    public void remove(long aircraftId) {  aircraftRepository.remove(aircraftId); }
}
