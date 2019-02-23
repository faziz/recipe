package com.faisal.exercise.rezdy.controller;

import com.faisal.exercise.rezdy.model.Recipes;
import com.faisal.exercise.rezdy.service.RecipeService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
    
    @Autowired
    private RecipeService recipeService;

    @GetMapping("lunch")
    public Recipes getRecipes() throws IOException {
        return recipeService.getRecipes();
    }
}
