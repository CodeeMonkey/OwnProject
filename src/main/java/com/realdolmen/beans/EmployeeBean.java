package com.realdolmen.beans;

import com.realdolmen.domain.EmployeeEntity;
import com.realdolmen.service.EmployeeServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EmployeeBean {

    @Inject
    EmployeeServiceBean employeeService;

    public EmployeeEntity save(EmployeeEntity employee){ return employeeService.save(employee); }
    public EmployeeEntity findById(long employeeId){ return employeeService.findById(employeeId); }
    public List<EmployeeEntity> findAll(){ return employeeService.findAll(); }
    public void remove(long employeeId){ employeeService.remove(employeeId); }


}
