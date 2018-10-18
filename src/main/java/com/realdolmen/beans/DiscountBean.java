package com.realdolmen.beans;

import com.realdolmen.domain.DiscountEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class DiscountBean {

    @PersistenceContext
    EntityManager em;

    //CRUDS
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
        em.remove(em.getReference(DiscountEntity.class, discountId));
    }
    //CRUDS
}
