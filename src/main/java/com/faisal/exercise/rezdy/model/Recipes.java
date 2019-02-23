package com.faisal.exercise.rezdy.model;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Recipes {

    private Set<Recipe> recipes;

    public Recipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipes() {
    }

    public Set<Recipe> getRecipes() {
        if (null == recipes) {
            recipes = new TreeSet<>();
        }
        return recipes;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.recipes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipes other = (Recipes) obj;
        return Objects.equals(this.recipes, other.recipes);
    }
    
    
}
