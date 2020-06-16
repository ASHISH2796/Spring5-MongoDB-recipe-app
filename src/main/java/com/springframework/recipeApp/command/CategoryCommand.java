package com.springframework.recipeApp.command;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
	private String id;
	private String description;
	private Set<RecipeCommand> recipes;
}
