package com.realdolmen.repository;

import com.realdolmen.domain.DiscountEntity;
import com.realdolmen.domain.DiscountEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DiscountRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public DiscountEntity save(DiscountEntity discount) {
        em.persist(discount);
        return discount;
    }

    public DiscountEntity findById(Long id) {
        return em.find(DiscountEntity.class, id);
    }

    public List<DiscountEntity> findAll() {
        return em.createQuery("select p from DiscountEntity p", DiscountEntity.class).getResultList();
    }

    public void remove(long discountId) {
        logger.info("Removing discount with id " + discountId);
        em.remove(em.getReference(DiscountEntity.class, discountId));
    }
}
