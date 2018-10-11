package com.realdolmen.beans;

import com.realdolmen.domain.PersonEntity;
import com.realdolmen.service.PersonServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PersonBean {

    @Inject
    PersonServiceBean airportService;

    public PersonEntity save(PersonEntity airport){ return airportService.save(airport); }
    public PersonEntity findById(long airportId){ return airportService.findById(airportId); }
    public List<PersonEntity> findAll(){
        return airportService.findAll();
    }
    public void remove(long airportId){
        airportService.remove(airportId);
    }


}
