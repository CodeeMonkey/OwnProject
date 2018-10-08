package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Recipe;
import com.realdolmen.course.domain.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RecipeRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public Recipe save(Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }

    public Recipe findById(Long id) {
        return em.find(Recipe.class, id);
    }

    public List<Recipe> findAll() {
        return em.createQuery("select p from Recipe p", Recipe.class).getResultList();
    }

    public void remove(long recipeId) {
        logger.info("Removing recipe with id " + recipeId);
        em.remove(em.getReference(Recipe.class, recipeId));
    }
}
