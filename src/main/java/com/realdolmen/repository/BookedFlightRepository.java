package com.realdolmen.repository;

import com.realdolmen.domain.BookedflightEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookedFlightRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

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
        logger.info("Removing bookedflight with id " + bookedflightId);
        em.remove(em.getReference(BookedflightEntity.class, bookedflightId));
    }
}
