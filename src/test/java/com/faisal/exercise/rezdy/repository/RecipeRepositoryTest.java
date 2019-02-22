package com.faisal.exercise.rezdy.repository;

import com.faisal.exercise.rezdy.model.Ingredients;
import com.faisal.exercise.rezdy.model.Recipes;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeRepositoryTest {
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    @Test
    public void testGetRecipes() throws Exception {
        Recipes recipes = recipeRepository.getRecipes();
        assertNotNull(recipes);
        assertFalse(recipes.getRecipes().isEmpty());
    }

    @Test
    public void testGetIngredients() throws Exception {
        Ingredients ingredients = recipeRepository.getIngredients();
        assertNotNull(ingredients);
        assertFalse(ingredients.getIngredients().isEmpty());
    }
}
