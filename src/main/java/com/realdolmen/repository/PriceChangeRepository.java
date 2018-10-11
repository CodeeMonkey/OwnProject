package com.realdolmen.repository;

import com.realdolmen.domain.PriceChangeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PriceChangeRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public PriceChangeEntity save(PriceChangeEntity priceChange) {
        em.persist(priceChange);
        return priceChange;
    }

    public PriceChangeEntity findById(Long id) {
        return em.find(PriceChangeEntity.class, id);
    }

    public List<PriceChangeEntity> findAll() {
        return em.createQuery("select p from PriceChangeEntity p", PriceChangeEntity.class).getResultList();
    }

    public void remove(long priceChangeId) {
        logger.info("Removing priceChange with id " + priceChangeId);
        em.remove(em.getReference(PriceChangeEntity.class, priceChangeId));
    }
}
