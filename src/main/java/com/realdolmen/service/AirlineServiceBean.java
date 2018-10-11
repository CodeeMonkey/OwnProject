package com.realdolmen.service;

import com.realdolmen.domain.AirlineEntity;
import com.realdolmen.repository.AirlineRepository;
import com.realdolmen.service.remotes.AirlineServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class AirlineServiceBean implements AirlineServiceRemote {

    @EJB
    AirlineRepository airlineRepository;

    @Override
    public AirlineEntity save(AirlineEntity airline) { return airlineRepository.save(airline); }

    @Override
    public AirlineEntity findById(Long id) {
        return airlineRepository.findById(id);
    }

    @Override
    public List<AirlineEntity> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public void remove(long airlineId) {
        airlineRepository.remove(airlineId);
    }
}
