package com.realdolmen.repository;

import com.realdolmen.domain.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public PersonEntity save(PersonEntity person) {
        em.persist(person);
        return person;
    }

    public PersonEntity findById(Long id) {
        return em.find(PersonEntity.class, id);
    }

    public List<PersonEntity> findAll() {
        return em.createQuery("select p from PersonEntity p", PersonEntity.class).getResultList();
    }

    public void remove(long personId) {
        logger.info("Removing person with id " + personId);
        em.remove(em.getReference(PersonEntity.class, personId));
    }
}
