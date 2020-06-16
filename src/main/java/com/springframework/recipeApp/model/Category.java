package com.springframework.recipeApp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipes"})
@Entity
public class Category {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	@ManyToMany(mappedBy = "category")
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
