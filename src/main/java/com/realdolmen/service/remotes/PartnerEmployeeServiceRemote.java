package com.realdolmen.service.remotes;

import com.realdolmen.domain.EmployeeEntity;
import com.realdolmen.domain.PartnerEmployeeEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PartnerEmployeeServiceRemote {
    PartnerEmployeeEntity save(PartnerEmployeeEntity employee);
    PartnerEmployeeEntity findById(Long id);
    List<PartnerEmployeeEntity> findAll();
    void remove(long employeeId);
}
