package com.realdolmen.service;

import com.realdolmen.domain.EmployeeEntity;
import com.realdolmen.repository.EmployeeRepository;
import com.realdolmen.service.remotes.EmployeeServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class EmployeeServiceBean implements EmployeeServiceRemote {

    @EJB
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void remove(long employeeId) {
        employeeRepository.remove(employeeId);
    }
}
