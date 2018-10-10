package com.realdolmen.service.remotes;

import com.realdolmen.domain.AirlineEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AirlineServiceRemote {
    AirlineEntity save(AirlineEntity airline);
    AirlineEntity findById(Long id);
    List<AirlineEntity> findAll();
    void remove(long airlineId);
}
