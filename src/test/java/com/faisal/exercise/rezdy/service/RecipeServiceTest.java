package com.faisal.exercise.rezdy.service;

import com.faisal.exercise.rezdy.model.Recipe;
import com.faisal.exercise.rezdy.model.Recipes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceTest {
    
    @Autowired
    private LunchRecipeService recipeService;
    
    @Before
    public void setUp() {
        assertNotNull(recipeService);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetRecipes() throws IOException {
        Recipes r = recipeService.getRecipes();
        assertNotNull(r);

        Set<Recipe> recipes = r.getRecipes();
        assertFalse(recipes.isEmpty());
        assertTrue(recipes.size() == 2);

        Recipe topRecipe = new ArrayList<>(recipes).get(0);
        assertEquals("Ham and Cheese Toastie", topRecipe.getTitle());

        Recipe bottomRecipe = new ArrayList<>(recipes).get(1);
        assertEquals("Hotdog", bottomRecipe.getTitle());
    }
}
