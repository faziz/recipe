package com.faisal.exercise.rezdy.controller;

import com.faisal.exercise.rezdy.model.Recipes;
import com.faisal.exercise.rezdy.service.LunchRecipeService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LunchController {
    
    @Autowired
    private LunchRecipeService lunchRecipeService;

    @GetMapping("lunch")
    public Recipes getRecipesForLunch() throws IOException {
        return lunchRecipeService.getRecipes();
    }
}
