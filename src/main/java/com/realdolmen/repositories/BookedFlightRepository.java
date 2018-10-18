package com.realdolmen.repositories;

import com.realdolmen.beans.CurrentUserBean;
import com.realdolmen.domain.BookedflightEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class BookedFlightRepository implements Serializable {
    @PersistenceContext
    private EntityManager em;

    public List<BookedflightEntity> findAvailableBookedFlight() {
        if(CurrentUserBean.isLoggedIn()){
        Long userFK = CurrentUserBean.getCurrentUser().getId();
        Query query = em.createNamedQuery(BookedflightEntity.SEARCH_ALL_BOOKEDFLIGHTS);
        query.setParameter("userId", userFK);
        return query.setMaxResults(20).getResultList();
        }
        return null;
    }
}
