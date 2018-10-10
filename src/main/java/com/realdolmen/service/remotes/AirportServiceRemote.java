package com.realdolmen.service.remotes;

import com.realdolmen.domain.AirportEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AirportServiceRemote {
    AirportEntity save(AirportEntity airport);
    AirportEntity findById(Long id);
    List<AirportEntity> findAll();
    void remove(long airportId);
}
