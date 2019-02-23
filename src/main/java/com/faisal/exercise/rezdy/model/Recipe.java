package com.faisal.exercise.rezdy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import static java.util.Objects.hash;
import java.util.Set;

public class Recipe implements Comparable<Recipe>{
    
    private String title;
    private Set<String> ingredients;
    @JsonIgnore
    private Integer relevance = -1;

    public Recipe() {
    }

    public Recipe(String title, Set<String> ingredients) {
        this.title = title;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public Recipe setRelevance(Integer relevance) {
        this.relevance = relevance;
        return this;
    }

    @Override
    public int hashCode() {
        return hash(this.ingredients, this.title);
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
        final Recipe other = (Recipe) obj;
        
        return Objects.equals(this.ingredients, other.ingredients) && 
            Objects.equals(this.title, other.title);
    }

    @Override
    public int compareTo(Recipe otherRecipe) {
        return this.relevance - otherRecipe.relevance;
    }
}
