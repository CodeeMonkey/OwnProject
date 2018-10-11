package com.realdolmen.repository;

import com.realdolmen.domain.AirlineEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AirlineRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public AirlineEntity save(AirlineEntity airline) {
        em.persist(airline);
        return airline;
    }

    public AirlineEntity findById(Long id) {
        return em.find(AirlineEntity.class, id);
    }

    public List<AirlineEntity> findAll() {
        return em.createQuery("select p from AirlineEntity p", AirlineEntity.class).getResultList();
    }

    public void remove(long airlineId) {
        logger.info("Removing airline with id " + airlineId);
        em.remove(em.getReference(AirlineEntity.class, airlineId));
    }
}
