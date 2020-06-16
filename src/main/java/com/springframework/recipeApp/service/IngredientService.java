package com.springframework.recipeApp.service;

import com.springframework.recipeApp.command.IngredientCommand;

public interface IngredientService {
   public IngredientCommand findIngredientByRecipeIdandIngredientId(String recipe_id , String ingredient_id);
   public IngredientCommand saveCommand(IngredientCommand command);
}
