package com.realdolmen.service;

import com.realdolmen.domain.SheduleEntity;
import com.realdolmen.repository.SheduleRepository;
import com.realdolmen.service.remotes.SheduleServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class SheduleServiceBean implements SheduleServiceRemote {

    @EJB
    SheduleRepository sheduleRepository;

    @Override
    public SheduleEntity save(SheduleEntity shedule) {
        return sheduleRepository.save(shedule);
    }

    @Override
    public SheduleEntity findById(Long id) {
        return sheduleRepository.findById(id);
    }

    @Override
    public List<SheduleEntity> findAll() {
        return sheduleRepository.findAll();
    }

    @Override
    public void remove(long sheduleId) {
        sheduleRepository.remove(sheduleId);
    }
}
