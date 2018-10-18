package com.realdolmen.beans;

import com.realdolmen.domain.AircraftEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class AircraftBean {

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
        em.remove(em.getReference(AircraftEntity.class, aircraftId));
    }
}
