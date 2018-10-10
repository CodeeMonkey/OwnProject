package com.realdolmen.service.remotes;

import com.realdolmen.domain.SheduleEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SheduleServiceRemote {
    SheduleEntity save(SheduleEntity sheduledFlights);
    SheduleEntity findById(Long id);
    List<SheduleEntity> findAll();
    void remove(long sheduledFlightsId);
}
