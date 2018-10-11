package com.realdolmen.service;

import com.realdolmen.domain.AirportEntity;
import com.realdolmen.repository.AirportRepository;
import com.realdolmen.repository.PersonRepository;
import com.realdolmen.service.remotes.AirportServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class AirportServiceBean implements AirportServiceRemote {

    @EJB
    AirportRepository airportRepository;

    @Override
    public AirportEntity save(AirportEntity airport) {
        return airportRepository.save(airport);
    }

    @Override
    public AirportEntity findById(Long id) { return airportRepository.findById(id); }

    @Override
    public List<AirportEntity> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public void remove(long airportId) {
        airportRepository.remove(airportId);
    }
}
