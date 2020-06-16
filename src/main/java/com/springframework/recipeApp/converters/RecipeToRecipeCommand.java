package com.springframework.recipeApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.springframework.recipeApp.command.RecipeCommand;
import com.springframework.recipeApp.model.Category;
import com.springframework.recipeApp.model.Recipe;

import lombok.Synchronized;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{

    private final CategoryToCategoryCommand categoryConveter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConveter, IngredientToIngredientCommand ingredientConverter,
                                 NotesToNotesCommand notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeCommand command = new RecipeCommand();
        command.setId(source.getId());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setDescription(source.getDescription());
        command.setDifficulty(source.getDifficulty());
        command.setDirection(source.getDirection());
        command.setServing(source.getServing());
        command.setSource(source.getSource());
        command.setUrl(source.getUrl());
        command.setImage(source.getImage());
        command.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategory() != null && source.getCategory().size() > 0){
            source.getCategory()
                    .forEach((Category category) -> command.getCategorycommand().add(categoryConveter.convert(category)));
        }

        if (source.getIngredient() != null && source.getIngredient().size() > 0){
            source.getIngredient()
                    .forEach(ingredient -> command.getIngredientcommand().add(ingredientConverter.convert(ingredient)));
        }

        return command;
    }
}
