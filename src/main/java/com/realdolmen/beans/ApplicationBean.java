package com.realdolmen.beans;

import com.realdolmen.domain.UserEntity;
import com.realdolmen.service.UserServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ApplicationBean {

    @Inject
    ApplicationServiceBean applicationService;

    public String getCurrentDate(){
        return applicationService.getCurrentDate;
    }


}
