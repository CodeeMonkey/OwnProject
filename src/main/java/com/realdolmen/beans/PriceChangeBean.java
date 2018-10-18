package com.realdolmen.beans;

import com.realdolmen.domain.PriceChangeEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class PriceChangeBean {

    @PersistenceContext
    EntityManager em;

    //CRUDS
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
        em.remove(em.getReference(PriceChangeEntity.class, priceChangeId));
    }
    //END CRUDS

}
