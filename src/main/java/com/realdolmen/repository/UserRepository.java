package com.realdolmen.repository;

import com.realdolmen.domain.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public UserEntity save(UserEntity user) {
        em.persist(user);
        return user;
    }

    public UserEntity findById(Long id) {
        return em.find(UserEntity.class, id);
    }

    public List<UserEntity> findAll() {
        return em.createQuery("select p from UserEntity p", UserEntity.class).getResultList();
    }

    public void remove(long userId) {
        logger.info("Removing user with id " + userId);
        em.remove(em.getReference(UserEntity.class, userId));
    }
}
