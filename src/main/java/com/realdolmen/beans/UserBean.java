package com.realdolmen.beans;

import com.realdolmen.domain.UserEntity;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Stateful
public class UserBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    //CRUDS
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
        em.remove(em.getReference(UserEntity.class, userId));
    }
    //END CRUDS



}
