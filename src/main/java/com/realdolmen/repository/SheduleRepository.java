package com.realdolmen.repository;

import com.realdolmen.domain.SheduleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SheduleRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public SheduleEntity save(SheduleEntity shedule){
        em.persist(shedule);
        return shedule;
    }

    public SheduleEntity findById(Long id) {
        return em.find(SheduleEntity.class, id);
    }

    public List<SheduleEntity> findAll() {
        return em.createQuery("select a from SheduleEntity a", SheduleEntity.class).getResultList();
    }

    public void remove(long sheduleId) {
        logger.info("Removing shedule with id " + sheduleId);
        em.remove(em.getReference(SheduleEntity.class, sheduleId));
    }
}
