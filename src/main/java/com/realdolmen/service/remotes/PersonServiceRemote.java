package com.realdolmen.service.remotes;

import com.realdolmen.domain.PersonEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonServiceRemote {
    PersonEntity save(PersonEntity person);
    PersonEntity findById(Long id);
    List<PersonEntity> findAll();
    void remove(long personId);
}
