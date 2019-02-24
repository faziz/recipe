package com.faisal.exercise.rezdy.controller;

import com.faisal.exercise.rezdy.model.Recipe;
import com.faisal.exercise.rezdy.model.Recipes;
import com.faisal.exercise.rezdy.service.LunchRecipeService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(LunchController.class)
public class LunchControllerTest {
    
    @MockBean
    private LunchRecipeService recipeService;
    @Autowired
    private MockMvc mvc;

    @Before
    public void setup() throws IOException {
        Set<String> ingredients = new HashSet<>();
        ingredients.add("Ham");
        ingredients.add("Cheese");
        ingredients.add("Bread");
        ingredients.add("Butter");
        Recipe recipe = new Recipe("Ham and Cheese Toastie", ingredients);
        
        Recipes recipes = new Recipes();
        recipes.getRecipes().add(recipe);
        given(this.recipeService.getRecipes())
            .willReturn(recipes);
    }

    @Test
    public void testGetRecipes() throws Exception {
        assertThat(mvc).isNotNull();

        mvc.perform(get("/lunch").
            contentType(APPLICATION_JSON)).
                andExpect(status().isOk()).
                    andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON)).
                        andExpect(jsonPath("recipes[0].title", is("Ham and Cheese Toastie")));
    }
}
