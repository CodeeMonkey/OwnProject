package com.realdolmen.course.service;

import com.realdolmen.course.domain.Ingredient;
import com.realdolmen.course.domain.Person;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IngredientServiceRemote {
    Ingredient save(Ingredient person);
    Ingredient findById(Long id);
    List<Ingredient> findAll();
    void remove(long personId);
}
