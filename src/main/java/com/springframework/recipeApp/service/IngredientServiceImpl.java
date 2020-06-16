package com.springframework.recipeApp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springframework.recipeApp.command.IngredientCommand;
import com.springframework.recipeApp.converters.IngredientCommandToIngredient;
import com.springframework.recipeApp.converters.IngredientToIngredientCommand;
import com.springframework.recipeApp.model.Ingredient;
import com.springframework.recipeApp.model.Recipe;
import com.springframework.recipeApp.repository.RecipeRepository;
import com.springframework.recipeApp.repository.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

	private final RecipeRepository recipeRepository;
	private final IngredientToIngredientCommand ingredientToIngredientCommand;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final IngredientCommandToIngredient commandToIngredient;
	
	public IngredientServiceImpl(RecipeRepository recipeRepository,
			IngredientToIngredientCommand ingredientToIngredientCommand,
			UnitOfMeasureRepository unitOfMeasureRepository, IngredientCommandToIngredient commandToIngredient) {
		this.recipeRepository = recipeRepository;
		this.ingredientToIngredientCommand = ingredientToIngredientCommand;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.commandToIngredient = commandToIngredient;
	}

	@Override
	@Transactional
	public IngredientCommand findIngredientByRecipeIdandIngredientId(long recipe_id, long ingredient_id) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(recipe_id);
		if(!recipeOptional.isPresent())
		{
			log.error("recipe not found id :"+recipe_id);
		}
		Recipe recipe =recipeOptional.get();
		Optional<IngredientCommand> ingredientCommandOptional=recipe.getIngredient().stream().
		filter(ingredient-> ingredient.getId().equals(ingredient_id))
		.map(ingredient->ingredientToIngredientCommand.convert(ingredient)).findFirst();
		
		return ingredientCommandOptional.get();
	}

	@Override
	@Transactional
	public IngredientCommand saveCommand(IngredientCommand command) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());
        if(!recipeOptional.isPresent()){
        	//todo toss error if not found!
            log.error("Recipe not found for id: " + command.getRecipeId());
            return new IngredientCommand();
        } else {
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe
                    .getIngredient()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if(ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUnitOfMeasure(unitOfMeasureRepository
                        .findById(command.getUnitOfMeasure().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this
            } else {
                //add new Ingredient
                recipe.addIngredient(commandToIngredient.convert(command));
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            //to do check for fail
            return ingredientToIngredientCommand.convert(savedRecipe.getIngredient().stream()
                    .filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId()))
                    .findFirst()
                    .get());
        }
	}

}
