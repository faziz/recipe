package com.faisal.exercise.rezdy.service;

import com.faisal.exercise.rezdy.model.Recipes;
import java.io.IOException;
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
    private RecipeService recipeService;
    
    @Before
    public void setUp() {
        assertNotNull(recipeService);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetRecipes() throws IOException {
        Recipes recipes = recipeService.getRecipes();
        assertNotNull(recipes);
        assertFalse(recipes.getRecipes().isEmpty());
    }
}
