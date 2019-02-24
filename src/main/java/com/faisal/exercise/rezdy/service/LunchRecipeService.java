package com.faisal.exercise.rezdy.service;

import com.faisal.exercise.rezdy.model.Ingredient;
import com.faisal.exercise.rezdy.model.Recipe;
import com.faisal.exercise.rezdy.model.Recipes;
import com.faisal.exercise.rezdy.repository.LunchRecipeRepository;
import static com.google.common.collect.Sets.*;
import java.io.IOException;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LunchRecipeService {
    
    @Autowired
    private LunchRecipeRepository recipeRepository;

    public Recipes getRecipes() throws IOException {

        Recipes recipes = recipeRepository.getRecipes();
        LocalDate now = now();

        //Predicate for all expired ingredients.
        Predicate<Ingredient> expired    = i -> now.isAfter(i.getUseBy());
        //Predicate for all best-before ingredients.
        Predicate<Ingredient> bestBefore = i -> now.isAfter(i.getBestBefore()) && now.isBefore(i.getUseBy());

        //From the source ingrediants, separate the expired and best-before ingrediants.
        Set<String> expiredIngredients    = collect(expired);
        Set<String> bestBeforeIngredients = collect(bestBefore);

        //Get recipes with expired ingrediants.
        Set<Recipe> recipesWithExpiredIngrediants = recipes.getRecipes().stream().
            filter(r -> contains(r.getIngredients(), expiredIngredients)).
                collect(toSet());
        //Get recipes with ingrediants in best-before category.
        Set<Recipe> recipesWithBestBeforeIngrediants = recipes.getRecipes().stream().
            filter(r -> !recipesWithExpiredIngrediants.contains(r)).
                filter(r -> contains(r.getIngredients(), bestBeforeIngredients)).
                    collect(toSet());
        
        Integer relevance = recipes.getRecipes().size();
        for (Recipe recipe : recipesWithBestBeforeIngrediants) {
            recipe.setRelevance(relevance++);
        }

        Set<Recipe> result = new TreeSet<>(recipes.getRecipes());
        result.removeAll(recipesWithExpiredIngrediants);

        return new Recipes(result);
    }

    private Boolean contains(Set<String> recipe, Set<String> ing) {
        return !intersection(recipe, ing).isEmpty();
    }

    private Set<String> collect(Predicate<Ingredient> predicate) throws IOException {
        return recipeRepository.getIngredients().getIngredients().
            stream().filter(predicate).map(i -> i.getTitle()).collect(toSet());
    }
}
