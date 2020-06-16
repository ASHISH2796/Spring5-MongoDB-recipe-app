package com.springframework.recipeApp.service;

import com.springframework.recipeApp.command.IngredientCommand;

public interface IngredientService {
   public IngredientCommand findIngredientByRecipeIdandIngredientId(long recipe_id , long ingredient_id);
   public IngredientCommand saveCommand(IngredientCommand command);
}
