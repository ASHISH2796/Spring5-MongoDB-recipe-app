package com.springframework.recipeApp.service;

import java.util.Set;

import com.springframework.recipeApp.command.RecipeCommand;
import com.springframework.recipeApp.model.Recipe;

public interface RecipeService {
  
	public Set<Recipe> getAllrecipe();
	public Recipe findById(String id);
	public RecipeCommand saveCommand(RecipeCommand recipeCommand);
	public RecipeCommand findByCommandID(String id);
	public void deleteById(String id);
	
}
