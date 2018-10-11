package com.realdolmen.beans;

import com.realdolmen.domain.SheduleEntity;
import com.realdolmen.service.SheduleServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class SheduleBean {

    @Inject
    SheduleServiceBean sheduleService;

    public SheduleEntity save(SheduleEntity shedule){ return sheduleService.save(shedule); }
    public SheduleEntity findById(long sheduleId){ return sheduleService.findById(sheduleId); }
    public List<SheduleEntity> findAll(){ return sheduleService.findAll(); }
    public void remove(long sheduleId){ sheduleService.remove(sheduleId); }


}
