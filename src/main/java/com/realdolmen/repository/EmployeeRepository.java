package com.realdolmen.repository;

import com.realdolmen.domain.EmployeeEntity;
import com.realdolmen.domain.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

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
        logger.info("Removing employee with id " + employeeId);
        em.remove(em.getReference(EmployeeEntity.class, employeeId));
    }
}
