package com.realdolmen.beans;

import com.realdolmen.domain.BookedflightEntity;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class BookedFlightBean {

    @PersistenceContext
    EntityManager em;

    //CRUDS
    public BookedflightEntity save(BookedflightEntity bookedflight) {
        em.persist(bookedflight);
        return bookedflight;
    }

    public BookedflightEntity findById(Long id) {
        return em.find(BookedflightEntity.class, id);
    }

    public List<BookedflightEntity> findAll() {
        return em.createQuery("select p from BookedflightEntity p", BookedflightEntity.class).getResultList();
    }

    public void remove(long bookedflightId) {
        em.remove(em.getReference(BookedflightEntity.class, bookedflightId));
    }
    //CRUDS


}
