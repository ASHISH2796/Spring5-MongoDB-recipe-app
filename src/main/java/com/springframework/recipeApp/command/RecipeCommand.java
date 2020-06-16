package com.springframework.recipeApp.command;

import java.util.HashSet;
import java.util.Set;

import com.springframework.recipeApp.model.Difficulty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer serving ;
	private String source;
	private String url;
	private String direction;
	private Difficulty difficulty;
	private Set<IngredientCommand>  ingredientcommand =new HashSet<>(); 
	private Byte[] image;
	private NotesCommand notes;
	private Set<CategoryCommand> categorycommand = new HashSet<>();
	
}
