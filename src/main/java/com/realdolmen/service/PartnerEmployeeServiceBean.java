package com.realdolmen.service;

import com.realdolmen.domain.PartnerEmployeeEntity;
import com.realdolmen.repository.PartnerEmployeeRepository;
import com.realdolmen.service.remotes.PartnerEmployeeServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class PartnerEmployeeServiceBean implements PartnerEmployeeServiceRemote {

    @EJB
    PartnerEmployeeRepository partnerEmployeeRepository;

    @Override
    public PartnerEmployeeEntity save(PartnerEmployeeEntity employee) {
        return partnerEmployeeRepository.save(employee);
    }

    @Override
    public PartnerEmployeeEntity findById(Long id) {
        return partnerEmployeeRepository.findById(id);
    }

    @Override
    public List<PartnerEmployeeEntity> findAll() {
        return partnerEmployeeRepository.findAll();
    }

    @Override
    public void remove(long employeeId) {
        partnerEmployeeRepository.remove(employeeId);
    }
}
