package com.realdolmen.service.remotes;

import com.realdolmen.domain.EmployeeEntity;
import com.realdolmen.domain.UserEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EmployeeServiceRemote {
    EmployeeEntity save(EmployeeEntity employee);
    EmployeeEntity findById(Long id);
    List<EmployeeEntity> findAll();
    void remove(long employeeId);
}
