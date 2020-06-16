package com.springframework.recipeApp.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springframework.recipeApp.command.RecipeCommand;
import com.springframework.recipeApp.converters.RecipeCommandToRecipe;
import com.springframework.recipeApp.converters.RecipeToRecipeCommand;
import com.springframework.recipeApp.model.Recipe;
import com.springframework.recipeApp.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> getAllrecipe() {
		log.info("im  here !");
		Set<Recipe> recipes =new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		 return recipes;
	}



	@Override
	public Recipe findById(String id) {
		Optional<Recipe> recipe =recipeRepository.findById(id);
		if(!recipe.isPresent())
		{
			throw new RuntimeException("No data found!");
		}
		return recipe.get();
	}



	@Override
	@Transactional
	public RecipeCommand saveCommand(RecipeCommand recipeCommand) {
		 Recipe recipe=recipeCommandToRecipe.convert(recipeCommand);
		 Recipe saverecipe=recipeRepository.save(recipe);
		 log.info("in Save command");
		 return recipeToRecipeCommand.convert(saverecipe);
	}
    
	@Override
	@Transactional
	public RecipeCommand findByCommandID(String id) {
		RecipeCommand recipeCommand=recipeToRecipeCommand.convert(findById(id));
		return recipeCommand;
	}
	
	@Override
	public void deleteById(String id) {
		recipeRepository.deleteById(id);
	}

}
