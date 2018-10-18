package com.realdolmen.beans;

import com.realdolmen.domain.EmployeeEntity;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EmployeeBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    //CRUDS
    public EmployeeEntity save(EmployeeEntity employee) {
        em.persist(employee);
        return employee;
    }

    public EmployeeEntity findById(Long id) {
        return em.find(EmployeeEntity.class, id);
    }

    public List<EmployeeEntity> findAll() {
        return em.createQuery("select e from EmployeeEntity e", EmployeeEntity.class).getResultList();
    }

    public void remove(long employeeId) {
        em.remove(em.getReference(EmployeeEntity.class, employeeId));
    }
    //END CRUDS

}
