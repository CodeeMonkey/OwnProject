package com.realdolmen.service.remotes;

import com.realdolmen.domain.AircraftEntity;
import com.realdolmen.domain.PersonEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AircraftServiceRemote {
    AircraftEntity save(AircraftEntity aircraft);
    AircraftEntity findById(Long id);
    List<AircraftEntity> findAll();
    void remove(long aircraftId);
}
