package com.realdolmen.beans;

import com.realdolmen.domain.PartnerEmployeeEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PartnerEmployeeBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    //CRUDS
    public PartnerEmployeeEntity save(PartnerEmployeeEntity employee) {
        em.persist(employee);
        return employee;
    }

    public PartnerEmployeeEntity findById(Long id) {
        return em.find(PartnerEmployeeEntity.class, id);
    }

    public List<PartnerEmployeeEntity> findAll() {
        return em.createQuery("select e from PartnerEmployeeEntity e", PartnerEmployeeEntity.class).getResultList();
    }

    public void remove(long employeeId) {
        em.remove(em.getReference(PartnerEmployeeEntity.class, employeeId));
    }
    //END CRUDS

}
