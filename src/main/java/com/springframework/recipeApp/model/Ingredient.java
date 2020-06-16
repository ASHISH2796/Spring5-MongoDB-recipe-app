package com.springframework.recipeApp.model;

import java.math.BigDecimal;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipe"})
public class Ingredient {
  
	private String id;
	private String description;
	private BigDecimal amount;
	
	private UnitOfMeasure unitOfMeasure; 
	
	private Recipe recipe;
	
	
	public Ingredient() {
	}
	
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure,Recipe recipe) {
		this.description = description;
		this.amount = amount;
		this.unitOfMeasure = unitOfMeasure;
		this.recipe =recipe;
	}

/*
	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public Long getId() {
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	*/
	
}
