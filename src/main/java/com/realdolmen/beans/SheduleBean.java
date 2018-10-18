package com.realdolmen.beans;

import com.realdolmen.domain.ScheduleEntity;
import com.realdolmen.domain.AirportEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class SheduleBean {

    @PersistenceContext
    EntityManager em;

    //CRUDS
    public ScheduleEntity save(ScheduleEntity shedule){
        em.persist(shedule);
        return shedule;
    }

    public ScheduleEntity findById(Long id) {
        return em.find(ScheduleEntity.class, id);
    }

    public List<ScheduleEntity> findAll() {
        return em.createQuery("select a from ScheduleEntity a", ScheduleEntity.class).getResultList();
    }

    public void remove(long sheduleId) {
        em.remove(em.getReference(ScheduleEntity.class, sheduleId));
    }


}
