package com.realdolmen.repository;

import com.realdolmen.domain.LoginEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LoginRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public LoginEntity save(LoginEntity login) {
        em.persist(login);
        return login;
    }

    public LoginEntity findById(Long id) {
        return em.find(LoginEntity.class, id);
    }

    public List<LoginEntity> findAll() {
        return em.createQuery("select l from LoginEntity l", LoginEntity.class).getResultList();
    }

    public void remove(long loginId) {
        logger.info("Removing login with id " + loginId);
        em.remove(em.getReference(LoginEntity.class, loginId));
    }
}
