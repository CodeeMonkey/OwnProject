package com.realdolmen.repository;

import com.realdolmen.domain.AirportEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AirportRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public AirportEntity save(AirportEntity airport){
        em.persist(airport);
        return airport;
    }

    public AirportEntity findById(Long id) {
        return em.find(AirportEntity.class, id);
    }

    public List<AirportEntity> findAll() {
        return em.createQuery("select a from AirportEntity a", AirportEntity.class).getResultList();
    }

    public void remove(long airportId) {
        logger.info("Removing airport with id " + airportId);
        em.remove(em.getReference(AirportEntity.class, airportId));
    }
}
