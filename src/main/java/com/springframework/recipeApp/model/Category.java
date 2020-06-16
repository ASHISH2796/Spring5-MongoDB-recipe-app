package com.springframework.recipeApp.model;

import java.util.Set;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipes"})
public class Category {
	
	private String id;
	private String description;
	
	private Set<Recipe> recipes;
	
/*	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Recipe> getRecipe() {
		return recipes;
	}
	public void setRecipe(Set<Recipe> recipes) {
		this.recipes = recipes;
	}
*/	
	
}
