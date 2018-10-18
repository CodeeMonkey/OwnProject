package com.realdolmen.repositories;

import com.realdolmen.domain.DiscountEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
@Named
public class DiscountRepository {
    @PersistenceContext
    private EntityManager em;

    public List<DiscountEntity> findAvailableDiscounts(Long airlineFK, Long scheduleFK) {
        Query query = em.createNamedQuery(DiscountEntity.SEARCH_AVAILABLE_DISCOUNTS);
        query.setParameter("airlineFK", airlineFK);
        query.setParameter("sheduleFK", scheduleFK);
        return query.setMaxResults(20).getResultList();
    }

    public List<DiscountEntity> findAllDiscounts() {
        Query query = em.createNamedQuery(DiscountEntity.SEARCH_ALL_DISCOUNTS);
        return query.getResultList();
    }
}
