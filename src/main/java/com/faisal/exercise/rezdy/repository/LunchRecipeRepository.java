package com.faisal.exercise.rezdy.repository;

import com.faisal.exercise.rezdy.model.Ingredients;
import com.faisal.exercise.rezdy.model.Recipe;
import com.faisal.exercise.rezdy.model.Recipes;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class LunchRecipeRepository {

    @Value("classpath:ingredients.json")
    private Resource ingredientSource;
    @Value("classpath:recipes.json")
    private Resource recipiesSource;

    public Recipes getRecipes() throws IOException {
        Recipes recipes = new ObjectMapper().
            readValue(recipiesSource.getInputStream(), Recipes.class);

        Integer relevance = 0;
        for (Recipe recipe : recipes.getRecipes()) {
            recipe.setRelevance(relevance++);
        }
        return recipes;
    }

    public Ingredients getIngredients() throws IOException {
        return new ObjectMapper().
            readValue(ingredientSource.getInputStream(), Ingredients.class);
    }
}
