package com.realdolmen.repository;

import com.realdolmen.domain.AircraftEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AircraftRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public AircraftEntity save(AircraftEntity aircraft) {
        em.persist(aircraft);
        return aircraft;
    }

    public AircraftEntity findById(Long id) {
        return em.find(AircraftEntity.class, id);
    }

    public List<AircraftEntity> findAll() {
        return em.createQuery("select p from AircraftEntity p", AircraftEntity.class).getResultList();
    }

    public void remove(long aircraftId) {
        logger.info("Removing aircraft with id " + aircraftId);
        em.remove(em.getReference(AircraftEntity.class, aircraftId));
    }
}
