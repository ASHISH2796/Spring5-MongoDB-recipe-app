package com.springframework.recipeApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.springframework.recipeApp.command.RecipeCommand;
import com.springframework.recipeApp.model.Recipe;

import lombok.Synchronized;

@Component
public class RecipeCommandToRecipe implements Converter< RecipeCommand , Recipe> {
   
	private final CategoryCommandToCategory categoryCommandToCategory;
	private final IngredientCommandToIngredient ingredientCommandToIngredient;
	private final NotesCommandToNotes notesCommandToNotes;
	
	public RecipeCommandToRecipe(CategoryCommandToCategory categoryCommandToCategory,
			IngredientCommandToIngredient ingredientCommandToIngredient, NotesCommandToNotes notesCommandToNotes) {
		this.categoryCommandToCategory = categoryCommandToCategory;
		this.ingredientCommandToIngredient = ingredientCommandToIngredient;
		this.notesCommandToNotes = notesCommandToNotes;
	}


	@Synchronized
	@Nullable
	@Override
	public Recipe convert(RecipeCommand source) {
		if(source == null) {
			return null;
		}
		final Recipe recipe =new Recipe();
		recipe.setId(source.getId());
		recipe.setDescription(source.getDescription());
		recipe.setPrepTime(source.getPrepTime());
		recipe.setCookTime(source.getCookTime());
		recipe.setServing(source.getServing());
		recipe.setSource(source.getSource());
		recipe.setUrl(source.getUrl());
		recipe.setDirection(source.getDirection());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setImage(source.getImage());
		recipe.setNotes(notesCommandToNotes.convert(source.getNotes()));
		if(source.getCategorycommand() !=null & source.getCategorycommand().size() >0) {
			 source.getCategorycommand().forEach(x->{
				 recipe.getCategory().add(categoryCommandToCategory.convert(x));
			 });
		}
		if(source.getIngredientcommand() != null && source.getCategorycommand().size()>0) {
			source.getIngredientcommand().forEach(x->{
				recipe.getIngredient().add(ingredientCommandToIngredient.convert(x));
			});
		}
		return recipe;
	}

}
