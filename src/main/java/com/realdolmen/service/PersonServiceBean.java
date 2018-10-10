package com.realdolmen.service;

import com.realdolmen.domain.PersonEntity;
import com.realdolmen.repository.PersonRepository;
import com.realdolmen.service.remotes.PersonServiceRemote;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class PersonServiceBean implements PersonServiceRemote {

    @EJB
    PersonRepository personRepository;

    @Override
    public PersonEntity save(PersonEntity person) {
        return personRepository.save(person);
    }

    @Override
    public PersonEntity findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void remove(long personId) {
        personRepository.remove(personId);
    }
}
