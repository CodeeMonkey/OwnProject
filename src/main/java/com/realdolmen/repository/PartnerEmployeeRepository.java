package com.realdolmen.repository;

import com.realdolmen.domain.EmployeeEntity;
import com.realdolmen.domain.PartnerEmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PartnerEmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

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
        logger.info("Removing partnerEmployee with id " + employeeId);
        em.remove(em.getReference(PartnerEmployeeEntity.class, employeeId));
    }
}
