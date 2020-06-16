package com.springframework.recipeApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.springframework.recipeApp.model.Recipe;

public interface RecipeRepository  extends CrudRepository<Recipe, Long>{

}
