package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class IngredientRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public Ingredient save(Ingredient ingredient) {
        em.persist(ingredient);
        return ingredient;
    }

    public Ingredient findById(Long id) {
        return em.find(Ingredient.class, id);
    }

    public List<Ingredient> findAll() {
        return em.createQuery("select p from Ingredient p", Ingredient.class).getResultList();
    }

    public void remove(long ingredientId) {
        logger.info("Removing ingredient with id " + ingredientId);
        em.remove(em.getReference(Ingredient.class, ingredientId));
    }
}
