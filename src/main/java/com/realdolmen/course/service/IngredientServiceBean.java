package com.realdolmen.course.service;

import com.realdolmen.course.domain.Ingredient;
import com.realdolmen.course.domain.Person;
import com.realdolmen.course.repository.IngredientRepository;
import com.realdolmen.course.repository.IngredientRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class IngredientServiceBean implements IngredientServiceRemote{
    @EJB
    IngredientRepository ingredientRepository;

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public void remove(long ingredientId) {
        ingredientRepository.remove(ingredientId);
    }
}
