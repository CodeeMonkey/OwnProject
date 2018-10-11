package com.realdolmen.beans;

import com.realdolmen.domain.PartnerEmployeeEntity;
import com.realdolmen.service.PartnerEmployeeServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PartnerEmployeeBean {

    @Inject
    PartnerEmployeeServiceBean partnerEmployeeService;

    public PartnerEmployeeEntity save(PartnerEmployeeEntity partnerEmployee){ return partnerEmployeeService.save(partnerEmployee); }
    public PartnerEmployeeEntity findById(long partnerEmployeeId){ return partnerEmployeeService.findById(partnerEmployeeId); }
    public List<PartnerEmployeeEntity> findAll(){ return partnerEmployeeService.findAll(); }
    public void remove(long partnerEmployeeId){ partnerEmployeeService.remove(partnerEmployeeId); }


}
