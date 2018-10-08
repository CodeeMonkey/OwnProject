package com.realdolmen.course.beans;

import com.realdolmen.course.domain.Ingredient;
import com.realdolmen.course.domain.Person;
import com.realdolmen.course.domain.Recipe;
import com.realdolmen.course.service.IngredientServiceBean;
import com.realdolmen.course.service.PersonServiceBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class IngredientsBean {


    @PersistenceContext
    EntityManager em;

    @Inject
    private IngredientServiceBean ingredientServiceBean;

    public List<Ingredient> allIngredients() {
        return ingredientServiceBean.findAll();
    }

    private List<Ingredient> ingredients;

    public Ingredient getById(long personId){

        Ingredient i = new Ingredient();
        i.setId((long)1);
        i.setName("Tomaat");
        Recipe r = new Recipe();

        r.setRecipeName("Pasta");
        r.setTimeRequired("41");

        List<Recipe> recepten = new ArrayList<Recipe>();


        em.persist(i);
        recepten.add(r);
        i.setRecipes(recepten);

        return ingredientServiceBean.findById(personId);
    }

    public void remove(long personId) {
        ingredientServiceBean.remove(personId);
    }

    public void select(long personId) {
        Ingredient i = new Ingredient();
        i.setId((long)1);
        i.setName("Tomaat");
        Recipe r = new Recipe();

        r.setRecipeName("Pasta");
        r.setTimeRequired("41");

        List<Recipe> recepten = new ArrayList<Recipe>();


        em.persist(i);


        recepten.add(r);
        i.setRecipes(recepten);


        ingredients.add(getById(personId));
    }


    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
