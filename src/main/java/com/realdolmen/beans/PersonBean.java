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
    private PersonServiceBean personService;

    public List<PersonEntity> allPeople() {
        return personService.findAll();
    }

    public void remove(long personId) {
        personService.remove(personId);
    }
}
